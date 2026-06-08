package grasp.deleon.app.service.impl;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.Order;
import grasp.deleon.app.entity.OrderItem;
import grasp.deleon.app.entity.OrderStatus;
import grasp.deleon.app.entity.Payment;
import grasp.deleon.app.mapper.OrderMapper;
import grasp.deleon.app.repository.OrderRepository;
import grasp.deleon.app.service.BaseOrderService;
import grasp.deleon.app.service.OrderCommandService;
import grasp.deleon.app.service.OrderQueryService;
import grasp.deleon.app.util.OrderNotFoundException;
import grasp.deleon.app.util.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;

// SOLID: SRP  - OrderServiceImpl handles business logic only. Mapping is in OrderMapper,
//               validation is in OrderValidator.
// SOLID: OCP  - New payment types (GCash, PayPal) can be added without changing this class.
// SOLID: DIP  - Depends on OrderRepository (interface), OrderMapper (component),
//               and OrderValidator (component) — not on concrete implementations.
// SOLID: ISP  - Implements two focused interfaces: OrderQueryService and OrderCommandService.
// OOP: Inheritance - Extends BaseOrderService to inherit logOperation().
// GRASP: Pure Fabrication - Service class with no real-world equivalent.
// GRASP: Low Coupling - Depends on abstractions, not concrete classes.
// GRASP: High Cohesion - Only handles order business logic.
@Service
public class OrderServiceImpl extends BaseOrderService
        implements OrderQueryService, OrderCommandService {

    // SOLID: DIP - All dependencies are interfaces or Spring-managed components,
    //              never concrete instantiations (no "new MySQLRepository()").
    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;
    private final OrderMapper orderMapper;

    // Constructor injection — preferred over field injection.
    // Spring automatically provides the correct implementations at startup.
    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderValidator orderValidator,
                            OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
        this.orderMapper = orderMapper;
    }

    // ---- QUERY OPERATIONS (OrderQueryService) ----

    // SOLID: ISP - This method belongs to OrderQueryService (read-only).
    @Override
    public List<OrderDTO> getAllOrders() {
        logOperation("GET ALL", null); // OOP: Inheritance - uses parent class method
        // DRY: Mapping delegated to OrderMapper — not repeated here.
        return orderMapper.toDTOList(orderRepository.findAll());
    }

    // SOLID: ISP - This method belongs to OrderQueryService (read-only).
    @Override
    public OrderDTO getOrderById(Long id) {
        logOperation("GET BY ID", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        // DRY: Mapping delegated to OrderMapper.
        return orderMapper.toDTO(order);
    }

    // ---- COMMAND OPERATIONS (OrderCommandService) ----

    // SOLID: ISP - This method belongs to OrderCommandService (write).
    // GRASP: Creator - creates Order and OrderItem objects.
    @Override
    public OrderDTO createOrder(OrderDTO dto) {
        logOperation("CREATE", null);

        // SOLID: SRP - Validation is delegated to OrderValidator, not done here.
        orderValidator.validate(dto);

        // GRASP: Creator - Order.create() is the factory method.
        Order order = Order.create(dto.getCustomerName());

        // GRASP: Creator - OrderItems are created and added to the Order.
        if (dto.getItems() != null) {
            for (OrderDTO.OrderItemDTO itemDTO : dto.getItems()) {
                // KISS: Simple, direct item creation — no over-engineering.
                OrderItem item = new OrderItem(
                        itemDTO.getProductName(),
                        itemDTO.getQuantity(),
                        itemDTO.getUnitPrice()
                );
                order.getItems().add(item);
            }
        }

        Order saved = orderRepository.save(order);
        return orderMapper.toDTO(saved);
    }

    // SOLID: ISP - This method belongs to OrderCommandService (write).
    @Override
    public OrderDTO updateOrderStatus(Long id, OrderStatus status) {
        logOperation("UPDATE STATUS", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(status);
        return orderMapper.toDTO(orderRepository.save(order));
    }

    // SOLID: ISP - This method belongs to OrderCommandService (write).
    @Override
    public void deleteOrder(Long id) {
        logOperation("DELETE", id);
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // SOLID: OCP + DIP - Accepts any Payment implementation. The method never changes
    //                    when a new payment type is added.
    // GRASP: Polymorphism - payment.process() is called on the interface.
    //                       The runtime decides which implementation runs.
    @Override
    public String processPayment(Long id, Payment payment) {
        logOperation("PROCESS PAYMENT", id);
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));

        // GRASP: Information Expert - calculateTotal() belongs to Order.
        double total = order.calculateTotal();

        // SOLID: LSP - CashPayment, CardPayment, or GCashPayment all work here
        //              because they all correctly fulfill the Payment contract.
        payment.process(total);

        return "Payment processed via " + payment.getMethodName()
                + " for order #" + id + " | Total: $" + total;
    }
}
