package com.plantilla.app.service;

import com.plantilla.app.entity.Order;
import com.plantilla.app.exception.ResourceNotFoundException;
import com.plantilla.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id: " + id));
    }

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order updateOrder(Long id, Order updatedOrder) {
        Order existing = getOrderById(id);
        existing.setOrderNumber(updatedOrder.getOrderNumber());
        existing.setCustomerName(updatedOrder.getCustomerName());
        existing.setTotalAmount(updatedOrder.getTotalAmount());
        existing.setStatus(updatedOrder.getStatus());
        existing.setPaymentMethod(updatedOrder.getPaymentMethod());
        return orderRepository.save(existing);
    }

    public void deleteOrder(Long id) {
        getOrderById(id);
        orderRepository.deleteById(id);
    }
}