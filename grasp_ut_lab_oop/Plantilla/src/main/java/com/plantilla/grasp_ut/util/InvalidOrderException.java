package com.plantilla.grasp_ut.util;

// High Cohesion
// Only does one thing: signals when order input is invalid
public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}