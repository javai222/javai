package com.grasp.cantela.Exception;

// GRASP: Pure Fabrication - Artificial exception class for error handling
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
