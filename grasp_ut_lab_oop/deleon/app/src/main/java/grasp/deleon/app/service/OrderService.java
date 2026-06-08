package grasp.deleon.app.service;

import grasp.deleon.app.dto.OrderDTO;
import grasp.deleon.app.entity.Order;
import grasp.deleon.app.entity.OrderItem;
import grasp.deleon.app.entity.OrderStatus;
import grasp.deleon.app.entity.Payment;
import grasp.deleon.app.repository.OrderRepository;
import grasp.deleon.app.util.OrderNotFoundException;
import grasp.deleon.app.util.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// GRASP: Pure Fabrication - OrderService does not map to a real-world object
//        It exists to hold business logic in a clean, dedicated place
// GRASP: High Cohesion - OrderService is only responsible for order business logic
// GRASP: Low Coupling - depends on OrderRepository (interface) not a concrete DB class
@Service
public class OrderService {

    // GRASP: Low Coupling - we inject the repository interface, not a concrete class
    private final OrderRepository orderRepository;
    private final OrderValidator orderValidator;

    // Constructor injection (preferred over @Autowired on fields)
    public OrderService(OrderRepository orderRepository, OrderValidator orderValidator) {
        this.orderRepository = orderRepository;
        this.orderValidator = orderValidator;
    }

    // ---- CREATE ----
    // GRASP: Creator - OrderService creates Order entities using the Order factory method
    public OrderDTO createOrder(OrderDTO dto) {
        // GRASP: Pure Fabrication - delegate validation to OrderValidator
        orderValidator.validate(dto);

        // GRASP: Creator - Order.create() is the factory method in the entity
        Order order = Order.create(dto.getCustomerName());

        // GRASP: Creator - OrderItem objects are created here and added to the Order
        if (dto.getItems() != null) {
            for (OrderDTO.OrderItemDTO itemDTO : dto.getItems()) {
                OrderItem item = new OrderItem(
                        itemDTO.getProductName(),
                        itemDTO.getQuantity(),
                        itemDTO.getUnitPrice()
                );
                order.getItems().add(item);
            }
        }

        // GRASP: Indirection - persistence goes through the repository
        Order saved = orderRepository.save(order);
        return toDTO(saved);
    }

    // ---- READ ALL ----
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // ---- READ ONE ----
    public OrderDTO getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return toDTO(order);
    }

    // ---- UPDATE STATUS ----
    public OrderDTO updateOrderStatus(Long id, OrderStatus status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(status);
        Order updated = orderRepository.save(order);
        return toDTO(updated);
    }

    // ---- DELETE ----
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // ---- PROCESS PAYMENT ----
    // GRASP: Polymorphism + Protected Variations - accepts any Payment implementation
    // The service does not know or care whether it is Cash or Card
    public String processPayment(Long id, Payment payment) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        double total = order.calculateTotal();
        payment.process(total);
        return "Payment processed via " + payment.getMethodName()
                + " for order #" + id + " total: $" + total;
    }

    // GRASP: Pure Fabrication - toDTO is a helper with no real-world equivalent
    // GRASP: High Cohesion - keeps entity-to-DTO conversion in one place
    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerName(order.getCustomerName());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());
        // GRASP: Information Expert - order.calculateTotal() is called on the Order itself
        dto.setTotal(order.calculateTotal());

        List<OrderDTO.OrderItemDTO> itemDTOs = order.getItems().stream()
                .map(item -> new OrderDTO.OrderItemDTO(
                        item.getProductName(),
                        item.getQuantity(),
                        item.getUnitPrice()))
                .collect(Collectors.toList());
        dto.setItems(itemDTOs);
        return dto;
    }
}
