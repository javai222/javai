package com.calculator.mance.exceptions;

/*
 * Custom UNCHECKED exception
 * This is thrown when negative values are not allowed in operations.
 * Example: if your calculator restricts negative numbers.
 */
public class NegativeValueException extends RuntimeException {

    // Constructor for custom message
    public NegativeValueException(String message) {
        super(message);
    }
}