package com.calculator.torrefranca.main;

import java.util.Scanner;

import com.calculator.torrefranca.exception.DiviByZero;
import com.calculator.torrefranca.exception.InputInvaliddException;
import com.calculator.torrefranca.exception.NegativeNum;
import com.calculator.torrefranca.service.Calculatorrrr;

public class CalculatorDemo_Torrefranca {

    public static void main(String[] args) {

        Calculatorrrr calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter first number: ");
            double a = calc.parseInput(scanner.nextLine());

            System.out.print("Enter second number: ");
            double b = calc.parseInput(scanner.nextLine());

            System.out.println("\n=== RESULTS ===");

            try {
                System.out.println("Add: " + calc.add(a, b));
            } catch (NegativeNum e) {
                System.out.println("Add Error: " + e.getMessage());
            }

            try {
                System.out.println("Subtract: " + calc.subtract(a, b));
            } catch (NegativeNum e) {
                System.out.println("Subtract Error: " + e.getMessage());
            }

            try {
                System.out.println("Multiply: " + calc.multiply(a, b));
            } catch (NegativeNum e) {
                System.out.println("Multiply Error: " + e.getMessage());
            }

            try {
                System.out.println("Divide: " + calc.divide(a, b));
            } catch (DiviByZero e) {
                System.out.println("Divide Error: " + e.getMessage());
            }

        } catch (InputInvaliddException e) {
            System.out.println("Input Error: " + e.getMessage());

        } finally {
            scanner.close();
            System.out.println("\nProgram ended.");
        }
    }
}
/*
1. EXCEPTIONS CREATED:
- InvalidInputException
- DivisionByZeroException
- NegativeNumberException

2. CHECKED VS UNCHECKED:
- Checked Exception:
  - None in the current final implementation (InvalidInputException is treated as RuntimeException for simplicity in design consistency).

- Unchecked Exceptions:
  - InvalidInputException (extends RuntimeException)
  - DivisionByZeroException (extends RuntimeException)
  - NegativeNumberException (extends RuntimeException)

All exceptions are runtime exceptions because they represent invalid user input or invalid mathematical operations during execution.

3. WHERE EXCEPTIONS ARE THROWN:
- InvalidInputException is thrown inside parseInput() when the user enters a non-numeric value.
- NegativeNumberException is thrown inside the validate() method when either input is less than zero.
- DivisionByZeroException is thrown inside the divide() method when the divisor is equal to zero.

4. WHERE EXCEPTIONS ARE HANDLED:
- All exceptions are handled in the CalculatorDemo class.
  - InvalidInputException is handled in the outer try-catch block during input parsing.
  - NegativeNumberException is handled individually inside each arithmetic operation block (add, subtract, multiply).
  - DivisionByZeroException is handled specifically inside the division operation block.

5. WHERE PROPAGATION OCCURS:
- Exceptions are thrown inside methods in the Calculator class.
- They propagate upward to the CalculatorDemo class if not immediately caught.
- The parseInput() method explicitly throws InvalidInputException, which is then caught in the main method.
- Other exceptions propagate from Calculator methods until they are handled in the demo class.

6. OOP CONCEPTS USED:
- Encapsulation: Validation logic (like checking negative values) is hidden inside private methods within the Calculator class.
- Abstraction: The Operations class defines basic arithmetic operations without exposing validation logic.
- Inheritance: Calculator extends Operations and reuses its methods while adding validation and exception handling.
- Polymorphism: Method overriding (same methods with modified behavior) and method overloading (if both int/double versions are used) demonstrate multiple forms of behavior.
*/
