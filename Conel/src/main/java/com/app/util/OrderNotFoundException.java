package com.app.util;

// GRASP: Protected Variations - custom exception shields service from raw JPA errors
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super("Order not found with id: " + id);
    }
}
