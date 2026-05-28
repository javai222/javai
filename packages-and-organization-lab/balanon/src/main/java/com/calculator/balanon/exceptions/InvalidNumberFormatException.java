package com.calculator.balanon.exceptions;

/*
 * Custom CHECKED exception
 * This is thrown when the user input is not a valid number.
 * Example: letters or symbols instead of numeric values.
 * Extends Exception so it must be handled using try-catch or throws.
 */
public class InvalidNumberFormatException extends Exception {

    // Constructor to pass error message
    public InvalidNumberFormatException(String message) {
        super(message);
    }
}