package com.tismo.productsapp.exception;

import com.tismo.productsapp.constants.ErrorMessages;

// GRASP: Pure Fabrication - Dedicated exception class for product-related errors
// SOLID: SRP - Dedicated exception for missing products
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super(String.format(
                ErrorMessages.PRODUCT_NOT_FOUND,
                id
        ));
    }
}