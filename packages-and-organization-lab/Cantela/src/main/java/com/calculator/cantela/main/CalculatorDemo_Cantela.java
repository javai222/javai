/*Created by Cantela, Chris Nelson B.

*What exceptions did you create?
- I created 5 exceptions: DivisionByZero, Factorial, InvalidInput, NegativeNumber, and UndefinedPointsException
*Which are checked vs unchecked?
- FactorialException, DivisionByZeroException, NegativeNumberException, and UndefinedPointsException are all unchecked exceptions, and InvalidInputException is a checked exception
*Where are exceptions thrown?
- division(), modulo() → DivisionByZeroException when divisor is 0
- squareRoot() → NegativeNumberException when input < 0
- factorial() → NegativeNumberException (negative), FactorialException (>170 or non-integer)
- parseExpression() → InvalidInputException when input cannot be parsed as double
- operation(), factorialExpression(), squareRootExpression() → InvalidInputException for invalid format
- tangent() → UndefinedPointsException when cos(a) ≈ 0 (odd multiples of π/2 radians)
*Where are they handled?
- All exceptions are handled in main() method with try-catch-finally block (lines 61-95)
- InvalidInputException caught at line 76, DivisionByZeroException at 78, NegativeNumberException at 80
- FactorialException at 82, UndefinedPointsException at 84, generic Exception at 86, finally block at 88
*Where does propagation occur?
- Exceptions propagate: Calculator method → operation/factorialExpression/squareRootExpression → main try block
- Caught by respective catch blocks in main, stopping propagation and displaying error message
*How did you apply OOP concepts?
- Inheritance: Calculator extends abstract Operators class inheriting operation contracts
- Abstraction: Operators abstract class hides implementation details behind interface
- Polymorphism: Method overloading (division, add, subtract, multiply with double and int parameters)
- Encapsulation: Private/protected access modifiers, exception classes encapsulate error information
- Custom exceptions: Each exception type handles specific error scenario enabling precise control flow
 
*How did you organize your packages?
- I organized packages under `com.calculator.cantela` and separated code into `main`, `service`, and `exceptions` folders.

*Why did you separate your classes this way?
- I separated classes by responsibility: `main` holds the demo runner, `service` contains calculator logic, and `exceptions` holds custom error types.

*How do packages improve encapsulation?
- Packages group related classes and hide implementation details, so only public APIs are exposed and internal classes stay isolated.

*Where are your exceptions located?
- The custom exceptions are located in `src/main/java/com/calculator/cantela/exceptions`.

*Why did you choose Maven or Gradle?
- I chose Maven because the lab asked for a build tool and I already set up a `pom.xml` in my personal project folder. Also because it's simple
and easy.
 */

package com.calculator.cantela.main;

import com.calculator.cantela.exceptions.*;
import com.calculator.cantela.service.Calculator;

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
                Operators available +, -, *, /, %, ^
                Unary Operators: sqrt, fact, sin, cos, tan, log
                Type 'unary' to switch to unary operators.
                Type 'exit' to quit
                """);

        // Main calculator loop - continues until user types 'exit'
        while (true) {
            
            System.out.print("-> ");
            input = in.nextLine().trim();

            // Check if user wants to exit program
            if (input.trim().equalsIgnoreCase("exit")) {
                System.out.println("Exiting program, Thank you.");
                break; // Exit the main loop
            }

            // Start try-catch block to handle any exceptions thrown by calculator operations
            try {

                if (input.trim().equalsIgnoreCase("unary")) {
                    System.out.println("""
                            
                            This is the unary section the format is (operator) (number) always put space between them.
                            For factorial: (number) (operator)
                            """);
                    System.out.print("-> ");
                     input = in.nextLine();

                     result = calculator.unaryOperation(input); // Perform unary operation (sqrt, fact, sin, etc.)
                    System.out.printf("Result %.4f\n", result);
                    continue;
                }

                // For any other input, treat it as binary operation (+, -, *, /, %, ^)
                // May throw InvalidInputException or DivisionByZeroException
                result = calculator.operation(input);
                System.out.printf("Result: %.4f\n", result);

            // EXCEPTION HANDLING - Each catch block handles a specific exception type
            // Exceptions propagate from Calculator methods and are caught here, stopping propagation
            } catch (InvalidInputException iie) {
                System.out.println("Error: " + iie.getMessage());
            } catch (DivisionByZerosException dze) {
                System.out.println("Error: " + dze.getMessage());
            } catch (NegativeNumberException nne) {
                System.out.println("Error: " + nne.getMessage());
            } catch (FactorialException fe) {
                System.out.println("Error: " + fe.getMessage());
            } catch (UndefinedPointsException upe) {
                System.out.println("Error: " + upe.getMessage());
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
