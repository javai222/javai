package com.calculator.balanon.exceptions;

/*
 * Custom UNCHECKED exception
 * This is thrown when the user tries to divide a number by zero.
 * Extends RuntimeException so it is not required to be handled using try-catch.
 */
public class ZeroDivisionException extends RuntimeException {

    // Constructor to pass custom error message
    public ZeroDivisionException(String message) {
        super(message);
    }
}