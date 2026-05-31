package com.plantilla.grasp_ut.service;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.repository.OrderRepository;
import com.plantilla.grasp_ut.util.OrderMapper;
import com.plantilla.grasp_ut.util.OrderNotFoundException;
import com.plantilla.grasp_ut.util.InvalidOrderException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

// SOLID: SRP - Only handles order business logic
// SOLID: DIP - Depends on abstractions not concrete classes
// SOLID: OCP - New features added via new classes not by modifying this class
// GRASP: Pure Fabrication, High Cohesion, Low Coupling
@Service
@RequiredArgsConstructor
public class OrderService {

    // SOLID: DIP - depends on interface not implementation
    private final OrderRepository orderRepository;

    // SOLID: DIP - depends on Payment interface not CashPayment etc.
    // SOLID: OCP - new payment types added without changing this class
    private final Map<String, Payment> paymentStrategies;

    private final OrderMapper orderMapper;

    // SOLID: SRP - validation extracted to OrderValidator
    // DRY: no repeated validation code here
    // Composition Over Inheritance - OrderService HAS-A OrderValidator
    private final OrderValidator orderValidator;

    @Transactional
    public OrderDTO.OrderResponse createOrder(OrderDTO.OrderRequest request) {
        // SOLID: SRP - validation delegated to OrderValidator
        orderValidator.validateRequest(request);

        Order order = Order.builder()
                .customerName(request.getCustomerName())
                .status("PENDING")
                .build();

        for (OrderDTO.OrderItemRequest itemReq : request.getItems()) {
            orderValidator.validateItem(itemReq);
            order.addItem(itemReq.getProductName(), itemReq.getPrice(), itemReq.getQuantity());
        }

        // SOLID: OCP + DIP
        if (request.getPaymentType() != null && !request.getPaymentType().isBlank()) {
            processPayment(request.getPaymentType(), order.calculateTotal());
        }

        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO.OrderResponse> getAllOrders() {
        return orderMapper.toResponseList(orderRepository.findAll());
    }

    @Transactional(readOnly = true)
    public OrderDTO.OrderResponse getOrderById(Long id) {
        if (id == null) throw new InvalidOrderException("Order ID must not be null");
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderMapper.toResponse(order);
    }

    @Transactional(readOnly = true)
    public List<OrderDTO.OrderResponse> getOrdersByCustomer(String customerName) {
        return orderMapper.toResponseList(orderRepository.findByCustomerName(customerName));
    }

    @Transactional
    public OrderDTO.OrderResponse updateOrderStatus(Long id, String newStatus) {
        if (newStatus == null || newStatus.isBlank()) {
            throw new InvalidOrderException("Status must not be empty");
        }
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        order.setStatus(newStatus.toUpperCase());
        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) throw new OrderNotFoundException(id);
        orderRepository.deleteById(id);
    }

    // SOLID: OCP - new payment types dont require changing this method
    // SOLID: DIP - uses Payment interface not concrete classes
    private void processPayment(String paymentType, double amount) {
        String key = switch (paymentType.toUpperCase()) {
            case "CREDIT_CARD" -> "creditCardPayment";
            case "GCASH"       -> "gcashPayment";
            default            -> "cashPayment";
        };
        Payment payment = paymentStrategies.getOrDefault(key, paymentStrategies.get("cashPayment"));
        payment.process(amount);
    }
}