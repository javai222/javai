package com.tismo.productsapp.exception;

// GRASP: Pure Fabrication - Dedicated exception class for product-related errors
public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(Long id) {
        super("Product with ID " + id + " not found.");
    }
}
