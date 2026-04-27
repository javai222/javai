// Created by De Leon, Lord Ulrick A.

/* 
1. How did you organize your packages?
I organized my packages into model, service, exception, and main under com.calculator.deleon to keep the project clean and structured.

2. Why did you separate your classes this way?
I separated the classes so that it remains organized and easier to locate and identify

3. How do packages improve encapsulation?
Packages improve encapsulation by controlling access to classes and methods.

4. Where are your exceptions located?
All exceptions are placed inside the com.calculator.deleon.exceptions.

5. Why did you choose Maven or Gradle?
I chose Maven because it is simple and makes it easy to build and manage the project structure.
*/

package com.calculator.deleon.main;

import java.util.Scanner;

import com.calculator.deleon.service.Calculator;
import com.calculator.deleon.exception.*;

public class CalculatorDemo_DeLeon {

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