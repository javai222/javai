//Created by Cantela, Chris Nelson B.
package exceptions;

// Unchecked exception - thrown when attempting to divide or modulo by zero
// Usage: division(a, 0), modulo(b, 0) in Calculator.java
public class DivisionByZeroException extends RuntimeException{
    public DivisionByZeroException (String message) {
        super(message);
    }
}
