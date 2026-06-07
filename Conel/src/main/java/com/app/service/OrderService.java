package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.repository.OrderRepository;
import com.app.util.OrderMapper;
import com.app.util.OrderNotFoundException;
import com.app.util.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

// GRASP: Pure Fabrication - service exists to hold business logic
// GRASP: High Cohesion - only handles order business logic
// GRASP: Low Coupling - depends on repository interface, not implementation
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final Payment payment; // GRASP: Low Coupling - depends on interface

    public Order createOrder(OrderDTO dto) {
        // GRASP: Creator - service delegates entity creation to mapper
        Order order = OrderMapper.toEntity(dto);
        Order saved = orderRepository.save(order);
        payment.process(saved.calculateTotal());
        return saved;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        // GRASP: Protected Variations - shields caller from JPA exceptions
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new OrderNotFoundException(id);
        }
        orderRepository.deleteById(id);
    }
}
