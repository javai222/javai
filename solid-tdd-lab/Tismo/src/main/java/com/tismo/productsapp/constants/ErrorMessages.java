package com.tismo.productsapp.constants;


// DRY: Centralized reusable error messages
public final class ErrorMessages {

    private ErrorMessages() {
        // Prevent instantiation
    }

    public static final String PRODUCT_NOT_FOUND =
            "Product with ID %d not found.";

    public static final String PRODUCT_NULL =
            "Product cannot be null.";
}