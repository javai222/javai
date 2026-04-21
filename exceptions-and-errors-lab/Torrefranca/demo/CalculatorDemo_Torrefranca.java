package demo;

import java.util.Scanner;

import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
import exceptions.DivisionByZeroException;
import model.Calculator;

public class CalculatorDemo_Torrefranca {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // INPUT
            System.out.print("Enter first number: ");
            double a = calc.parseInput(scanner.nextLine());

            System.out.print("Enter second number: ");
            double b = calc.parseInput(scanner.nextLine());

            System.out.println("\n=== RESULTS ===");

            // ADD
            try {
                System.out.println("Add: " + calc.add(a, b));
            } catch (NegativeNumberException e) {
                System.out.println("Add Error: " + e.getMessage());
            }

            // SUBTRACT
            try {
                System.out.println("Subtract: " + calc.subtract(a, b));
            } catch (NegativeNumberException e) {
                System.out.println("Subtract Error: " + e.getMessage());
            }

            // MULTIPLY
            try {
                System.out.println("Multiply: " + calc.multiply(a, b));
            } catch (NegativeNumberException e) {
                System.out.println("Multiply Error: " + e.getMessage());
            }

            // DIVIDE
            try {
                System.out.println("Divide: " + calc.divide(a, b));
            } catch (DivisionByZeroException e) {
                System.out.println("Divide Error: " + e.getMessage());
            }

        } catch (InvalidInputException e) {
            System.out.println("Input Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());

        } finally {
            scanner.close();
            System.out.println("\nProgram ended.");
        }
    }
}

/* 1. EXCEPTIONS CREATED:
- InvalidNumberFormatException
- NegativeValueException
- ZeroDivisionException

2. CHECKED VS UNCHECKED:
- Checked Exception:
  - InvalidNumberFormatException (extends Exception), because it requires explicit handling or declaration using throws.

- Unchecked Exceptions:
  - NegativeValueException (extends RuntimeException)
  - ZeroDivisionException (extends RuntimeException)
  These are runtime exceptions because they occur due to invalid logic or user input during execution.

3. WHERE EXCEPTIONS ARE THROWN:
- InvalidNumberFormatException is thrown inside the parseInput() method when the input cannot be converted into a valid number.
- NegativeValueException is thrown inside the validation method (checkNegative) when either input value is less than zero.
- ZeroDivisionException is thrown inside the divide() method when the divisor is equal to zero.

4. WHERE EXCEPTIONS ARE HANDLED:
- All exceptions are handled in the CalculatorDemo class.
  - InvalidNumberFormatException is handled in the outer try-catch block during input parsing.
  - NegativeValueException is handled inside individual try-catch blocks for each arithmetic operation.
  - ZeroDivisionException is handled specifically in the division operation block to prevent program crash.

5. WHERE PROPAGATION OCCURS:
- Exceptions are thrown from methods inside the Calculator class.
- They propagate upward through the call stack until they reach CalculatorDemo, where they are caught.
- In particular, parseInput() explicitly declares "throws InvalidNumberFormatException", allowing propagation before handling in the main method.

6. OOP CONCEPTS USED:
- Encapsulation: Validation logic (such as checking negative values) is hidden inside private methods within the Calculator class.
- Abstraction: The Operations class defines the structure of arithmetic operations while hiding implementation details.
- Inheritance: The Calculator class extends Operations, reusing and enhancing its functionality.
- Polymorphism: Method overloading (same method name with different parameters) and method overriding are used to provide multiple behaviors for arithmetic operations.
*/
