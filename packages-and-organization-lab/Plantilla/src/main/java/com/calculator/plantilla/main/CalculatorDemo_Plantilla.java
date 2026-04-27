// Code-Based Analysis
/*
  1. How did you organize your packages?
  - I organized my packages into four folders inside my main folder named Plantilla. 
    The four folders named model, service, exception, and main to easily put my class files and organize it.
  
  2. Why did you separate your classes this way?
  - I separate it because each of my class file have single responsibility.
  
  3. How do packages improve encapsulation?
  - Packages improve encapsulation by organizing the classes together with the same responsibility
    and using access modifiers to control the access of the users.
  
  4. Where are your exceptions located?
  - The exceptions are located in the package of com.calculator.plantilla.exception.
  
  5. Why did you choose Maven or Gradle?
  - I choose Gradle since it is faster and more flexible than Maven. 
*/

package com.calculator.plantilla.main;

import java.util.Scanner;

import com.calculator.plantilla.service.Calculator;
import com.calculator.plantilla.exception.*; // Use to import everything in the exception package

public class CalculatorDemo_Plantilla {

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