// Demo Class created by De Leon, Plantilla, and Silva

/*
1. What exceptions did you create?


2. Which are checked vs unchecked?


3. Where are exceptions thrown?
The exceptions are thrown inside the Calculator class methods whenever invalid inputs like zero division or negative numbers are detected.

4. Where are they handled?
They are handled in the CalculatorDemo_Silva_Plantilla_DeLeon class using separate try-catch blocks for each scenario.

5. Where does propagation occur?


6. How did you apply OOP concepts?


*/

package Demo;

import java.util.Scanner;

import Models.Calculator;
import Exceptions.DivisionByZeroException;
import Exceptions.InvalidInputException;
import Exceptions.NegativeNumbersException;

public class CalculatorDemo_Silva_Plantilla_DeLeon {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        try {
            // Ask user for first number
            System.out.print("Enter first number: ");
            double a = calc.checkValidity(scanner.nextLine());

            // Ask user for second number
            System.out.print("Enter second number: ");
            double b = calc.checkValidity(scanner.nextLine());

            // Display operation choices
            System.out.println("\nChoose operation:");
            System.out.println("1 - Add");
            System.out.println("2 - Subtract");
            System.out.println("3 - Multiply");
            System.out.println("4 - Divide");

            int choice = scanner.nextInt();
            double result;

            if (choice == 1) {
                // Calls add method
                result = calc.add(a, b);
                System.out.println("Result: " + result);

            } else if (choice == 2) {
                // Calls subtract method
                result = calc.subtract(a, b);
                System.out.println("Result: " + result);

            } else if (choice == 3) {
                // Calls multiply method
                result = calc.multiply(a, b);
                System.out.println("Result: " + result);

            } else if (choice == 4) {
                // Calls divide method
                result = calc.divide(a, b);
                System.out.println("Result: " + result);

            } else {
                // Handles invalid menu choice
                System.out.println("Invalid operation choice.");
            }

        // Handles Checked Exception
        } catch (InvalidInputException e) {
            System.out.println("Invalid Input: " + e.getMessage());

        // Handles Division by Zero
        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());

        // Handles Negative Numbers
        } catch (NegativeNumbersException e) {
            System.out.println("Error: " + e.getMessage());

        // Handles Non-integer
        } catch (Exception e) {
            System.out.println("Invalid data type! Please enter numbers only.");

        } finally {
            // Always runs whether exception occurs or not
            System.out.println("\nCalculator operations finished.");

            scanner.close();
        }
    }
}
