package com.plantilla.grasp_ut.util;

// High Cohesion
// Only does one thing: signals when an order is not found
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}