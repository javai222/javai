package com.example.demo.exception;

// Custom exception for invalid user list
public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message) {
        super(message);
    }
}