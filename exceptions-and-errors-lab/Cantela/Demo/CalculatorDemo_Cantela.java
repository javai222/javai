/*Created by Cantela, Chris Nelson B.

*What exceptions did you create?
- I created 4 exceptions DivisionByZero, Factorial, InvalidInput, and NegativeNumberException
*Which are checked vs unchecked?
- FactorialException, DivisionByZeroException,
  and NegativeNumberException are all unchecked exception, and InvalidInputException
  is a checked exception
*Where are exceptions thrown?
- division(), modulo() → DivisionByZeroException when divisor is 0
- squareRoot() → NegativeNumberException when input < 0
- factorial() → NegativeNumberException (negative), FactorialException (>170 or non-integer)
- parseExpression() → InvalidInputException when input cannot be parsed as double
- operation(), factorialExpression(), squareRootExpression() → InvalidInputException for invalid format
*Where are they handled?
- All exceptions are handled in main() method with try-catch-finally block (lines 61-95)
- InvalidInputException caught at line 76, DivisionByZeroException at 78, NegativeNumberException at 80
- FactorialException at 82, generic Exception at 84, finally block at 86
*Where does propagation occur?
- Exceptions propagate: Calculator method → operation/factorialExpression/squareRootExpression → main try block
- Caught by respective catch blocks in main, stopping propagation and displaying error message
*How did you apply OOP concepts?
- Inheritance: Calculator extends abstract Operators class inheriting operation contracts
- Abstraction: Operators abstract class hides implementation details behind interface
- Polymorphism: Method overloading (division, add, subtract, multiply with double and int parameters)
- Encapsulation: Private/protected access modifiers, exception classes encapsulate error information
- Custom exceptions: Each exception type handles specific error scenario enabling precise control flow
 */

package Demo;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.FactorialException;
import exceptions.NegativeNumberException;
import models.Calculator;

import java.util.Scanner;

// Main demo class - Interactive calculator with exception handling
public class CalculatorDemo_Cantela {
    public static void main(String[] args) {
        
        Calculator calculator = new Calculator();       // Initialize calculator instance - will handle all arithmetic operations
        Scanner in = new Scanner(System.in);
        String input;
        double result;

        // Display calculator information and supported operations to user
        System.out.println("""
                ===== Calculator =====
                Format: (number) (operator) (number) make sure there is space between them
                Operators available +, -, *, /, %, ^, !, sqr
                Type factorial or sqr (Square root) to access these operators: !, sqr
                Type 'exit' to quit
                """);

        // Main calculator loop - continues until user types 'exit'
        while (true) {
            
            System.out.print("-> ");
            input = in.nextLine().trim();

            // Check if user wants to exit program
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program, Thank you.");
                break; // Exit the main loop
            }

            // Start try-catch block to handle any exceptions thrown by calculator operations
            try {

                // Check if user is requesting factorial operation
                if (input.trim().equalsIgnoreCase("factorial")) {
                    
                    System.out.print("\nFactorial format: (number) (!): always put a space between them  \n-> ");
                    input = in.nextLine();

                    // Call factorialExpression method - may throw InvalidInputException, FactorialException, or NegativeNumberException
                    result = calculator.factorialExpression(input);
                    System.out.printf("Result: %.4f\n", result);
                    continue; // Skip to next iteration of main loop
                }

                // Check if user is requesting square root operation (accept multiple formats)
                if (input.trim().equalsIgnoreCase("sqr") ||
                        input.trim().equalsIgnoreCase("sqrt") ||
                        input.trim().equalsIgnoreCase("square root")) {

                    System.out.print("\nSquare Root format: (sqr) (number): always put a space between them  \n-> ");
                    input = in.nextLine();

                    // Call squareRootExpression method - may throw InvalidInputException or NegativeNumberException
                    result = calculator.squareRootExpression(input);
                    System.out.printf("Result: %.4f\n", result);
                    continue; // Skip to next iteration of main loop
                }

                // For any other input, treat it as binary operation (+, -, *, /, %, ^)
                // May throw InvalidInputException or DivisionByZeroException
                result = calculator.operation(input);
                System.out.printf("Result: %.4f\n", result);

            // EXCEPTION HANDLING - Each catch block handles a specific exception type
            // Exceptions propagate from Calculator methods and are caught here, stopping propagation
            } catch (InvalidInputException iie) {
                System.out.println("Error: " + iie.getMessage());
            } catch (DivisionByZeroException dze) {
                System.out.println("Error: " + dze.getMessage());
            } catch (NegativeNumberException nne) {
                System.out.println("Error: " + nne.getMessage());
            } catch (FactorialException fe) {
                System.out.println("Error: " + fe.getMessage());
            } catch (Exception e) {
                System.out.println("Bruh what did you to? how did you manage to crash my program!!");
            } finally {
                // Always executes after try block (whether exception occurred or not)
                // Readies the program for the next computation iteration
                System.out.println("\nNew Expression");
            }
        }

    }
}
