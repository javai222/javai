package com.plantilla.grasp_ut.service;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.repository.OrderRepository;
import com.plantilla.grasp_ut.util.InvalidOrderException;
import com.plantilla.grasp_ut.util.OrderMapper;
import com.plantilla.grasp_ut.util.OrderNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//  Pure Fabrication - exists to hold business logic
//  High Cohesion - only handles order business logic
//  Low Coupling - depends on interfaces not concrete classes
@Service
@RequiredArgsConstructor
public class OrderService {

    //  Indirection - uses repository interface not database directly
    //  Low Coupling - depends on interface not implementation
    private final OrderRepository orderRepository;

    //Low Coupling - depends on Payment interface not CashPayment etc.
    private final Map<String, Payment> paymentStrategies;

    private final OrderMapper orderMapper;

    // Create a new order
    @Transactional
    public OrderDTO.OrderResponse createOrder(OrderDTO.OrderRequest request) {
        if (request.getCustomerName() == null || request.getCustomerName().isBlank()) {
            throw new InvalidOrderException("Customer name must not be empty");
        }
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new InvalidOrderException("Order must have at least one item");
        }

        // Creator - we build the Order object here
        Order order = Order.builder()
                .customerName(request.getCustomerName())
                .status("PENDING")
                .build();

        // Creator - delegate item creation to Order entity itself
        for (OrderDTO.OrderItemRequest itemReq : request.getItems()) {
            validateItem(itemReq);
            order.addItem(itemReq.getProductName(), itemReq.getPrice(), itemReq.getQuantity());
        }

        // Polymorphism + Protected Variations
        // We don't care which payment type runs, just call the interface
        if (request.getPaymentType() != null && !request.getPaymentType().isBlank()) {
            processPayment(request.getPaymentType(), order.calculateTotal());
        }

        Order saved = orderRepository.save(order);
        return orderMapper.toResponse(saved);
    }

    // Get all orders
    @Transactional(readOnly = true)
    public List<OrderDTO.OrderResponse> getAllOrders() {
        return orderMapper.toResponseList(orderRepository.findAll());
    }

    // Get one order by ID
    @Transactional(readOnly = true)
    public OrderDTO.OrderResponse getOrderById(Long id) {
        if (id == null) {
            throw new InvalidOrderException("Order ID must not be null");
        }
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return orderMapper.toResponse(order);
    }

    // Get orders by customer name
    @Transactional(readOnly = true)
    public List<OrderDTO.OrderResponse> getOrdersByCustomer(String customerName) {
        return orderMapper.toResponseList(orderRepository.findByCustomerName(customerName));
    }

    // Update order status
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

    // Delete an order
    @Transactional
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }

    // Polymorphism + Low Coupling
    // Picks the right payment type using the interface
    private void processPayment(String paymentType, double amount) {
        String key = switch (paymentType.toUpperCase()) {
            case "CREDIT_CARD" -> "creditCardPayment";
            case "GCASH"       -> "gcashPayment";
            default            -> "cashPayment";
        };
        Payment payment = paymentStrategies.getOrDefault(key, paymentStrategies.get("cashPayment"));
        payment.process(amount);
    }

    // Validate a single item
    private void validateItem(OrderDTO.OrderItemRequest item) {
        if (item.getProductName() == null || item.getProductName().isBlank()) {
            throw new InvalidOrderException("Product name must not be empty");
        }
        if (item.getPrice() < 0) {
            throw new InvalidOrderException("Price must not be negative");
        }
        if (item.getQuantity() <= 0) {
            throw new InvalidOrderException("Quantity must be greater than zero");
        }
    }
}