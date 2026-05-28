//Created by Cantela, Chris Nelson B.
package com.calculator.cantela.exceptions;

// Unchecked exception - thrown when mathematical operations result in undefined points
// Thrown when: tangent(a) where cos(a) ≈ 0 (odd multiples of π/2 radians, e.g., 90°, 270°)
// Usage: tangent() method in Calculator.java
public class UndefinedPointsException extends RuntimeException {
    public UndefinedPointsException(String message) {
        super(message);
    }
}
