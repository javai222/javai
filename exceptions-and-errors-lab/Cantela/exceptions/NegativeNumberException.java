//Created by Cantela, Chris Nelson B.
package exceptions;

// Unchecked exception - thrown for operations that cannot handle negative numbers
// Thrown when: sqrt(negative) or factorial(negative)
// Usage: squareRoot() and factorial() methods in Calculator.java
public class NegativeNumberException extends RuntimeException {
    public NegativeNumberException(String message) {
        super(message);
    }
}
