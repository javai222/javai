
/*
1. How did you organize your packages?
I organize all my packages depending on their name and functions
which makes it easier for me to identify whic package should I put
in my code files

2. Why did you separate your classes this way?
To make it more organize and tied up with their own responsibilities

3. How do packages improve encapsulation?
Packages improve encapsulation by limiting the access and grouping related classes

4. Where are your exceptions located?
All the exceptions are located in package com.calculator.silva.exceptions

5. Why did you choose Maven or Gradle?
I choose Gradle because it is more flexible and provide a faster process than maven
*/

package com.calculator.silva.main;

import com.calculator.silva.exceptions.DivisionByZeroException;
import com.calculator.silva.exceptions.InvalidInputException;
import com.calculator.silva.exceptions.NegativeNumbersException;
import com.calculator.silva.service.Calculator;

import java.util.Scanner;

public class CalculatorDemo_Silva {

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