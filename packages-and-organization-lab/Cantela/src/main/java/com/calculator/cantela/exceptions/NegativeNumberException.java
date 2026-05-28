//Created by Cantela, Chris Nelson B.
package com.calculator.cantela.exceptions;

// Unchecked exception - thrown for operations that cannot handle negative numbers
// Thrown when: sqrt(negative) or factorial(negative)
// Usage: squareRoot(), factorial(), and logarithm() methods in Calculator.java
public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}
