 // Author: Balanon, Ryan James M.

/*
1. How did you organize your packages?
I grouped my files into packages:
- model (for the abstract class)
- service (for the calculator logic)
- exceptions (for custom errors)
- main (for user input and output)

2. Why did you separate your classes this way?
I separated them based on their purpose so the code is easier to understand,
organize, and maintain.

3. How do packages improve encapsulation?
Packages help control access and keep related code together.
This prevents other parts of the program from directly accessing internal logic.

4. Where are your exceptions located?
All custom exceptions are placed in:
com.calculator.balanon.exceptions

5. Why did you choose Maven or Gradle?
I used Gradle because it is simple, flexible, and faster for building projects.
It is also easy to use for beginners.
*/

package com.calculator.balanon;

import java.util.Scanner;

import com.calculator.balanon.exceptions.InvalidNumberFormatException;
import com.calculator.balanon.exceptions.NegativeValueException;
import com.calculator.balanon.exceptions.ZeroDivisionException;
import com.calculator.balanon.service.CalcService;

public class CalculatorDemo_Balanon {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        CalcService calculator = new CalcService();

        try {
            // Get first value
            System.out.print("Input first value: ");
            double num1 = calculator.parseInput(input.nextLine());

            // Get second value
            System.out.print("Input second value: ");
            double num2 = calculator.parseInput(input.nextLine());

            System.out.println("\n--- CALCULATION OUTPUT ---");

            // Addition
            try {
                double sum = calculator.add(num1, num2);
                System.out.println("Sum: " + sum);
            } catch (NegativeValueException ex) {
                System.out.println("Addition failed: " + ex.getMessage());
            }

            // Subtraction
            try {
                double difference = calculator.subtract(num1, num2);
                System.out.println("Difference: " + difference);
            } catch (NegativeValueException ex) {
                System.out.println("Subtraction failed: " + ex.getMessage());
            }

            // Multiplication
            try {
                double product = calculator.multiply(num1, num2);
                System.out.println("Product: " + product);
            } catch (NegativeValueException ex) {
                System.out.println("Multiplication failed: " + ex.getMessage());
            }

            // Division
            try {
                double quotient = calculator.divide(num1, num2);
                System.out.println("Quotient: " + quotient);
            } catch (ZeroDivisionException ex) {
                System.out.println("Division failed: " + ex.getMessage());
            }

        } catch (InvalidNumberFormatException ex) {
            System.out.println("Invalid input detected: " + ex.getMessage());

        } catch (Exception ex) {
            System.out.println("System error occurred: " + ex.getMessage());

        } finally {
            input.close();
            System.out.println("\nExecution finished.");
        }
    }
}



