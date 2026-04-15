//Created by Cantela, Chris Nelson B.
package exceptions;

// Checked exception - thrown when user input doesn't match expected format or cannot be parsed
// Usage: parseExpression(), operation(), factorialExpression(), squareRootExpression()
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }

    // Constructor with message and underlying cause (for exception chaining)
    public InvalidInputException (String message, Throwable cause) {
        super(message, cause);
    }
}
