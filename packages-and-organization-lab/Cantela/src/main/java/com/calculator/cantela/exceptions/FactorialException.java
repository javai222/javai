//Created by Cantela, Chris Nelson B.
package com.calculator.cantela.exceptions;

// Unchecked exception - thrown for invalid factorial operations
// Thrown when: number > 170 (causes double overflow) or input is not an integer
// Usage: factorial() method in Calculator.java
public class FactorialException extends RuntimeException {
    public FactorialException(String message) {
        super(message);
    }
}
