package com.grasp.cantela.Exception;

// GRASP: Pure Fabrication - Artificial exception class for error handling
// OOP: Custom exception — Clear domain signal for “missing resource” vs generic runtime failures.
// KISS — Thin wrapper around message-only {@link RuntimeException} (no over-engineered hierarchy).
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
