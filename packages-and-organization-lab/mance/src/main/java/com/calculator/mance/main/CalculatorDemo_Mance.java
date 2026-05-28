 // Class Created by Mance, John Roque R.

package com.calculator.mance.main;

import java.util.Scanner;

import com.calculator.mance.exceptions.InvalidNumberFormatException;
import com.calculator.mance.exceptions.NegativeValueException;
import com.calculator.mance.exceptions.ZeroDivisionException;
import com.calculator.mance.service.CalculatorService;

public class CalculatorDemo_Mance {
    public static void main(String[] args) {

        CalculatorService calc = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        try {
            // INPUT 1: first number from user
            System.out.print("Enter first number (or press Enter for default 5): ");
            String input1 = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
            double a = input1.isEmpty() ? 5.0 : calc.parseInput(input1);

            // INPUT 2: second number from user
            System.out.print("Enter second number (or press Enter for default 3): ");
            String input2 = scanner.hasNextLine() ? scanner.nextLine().trim() : "";
            double b = input2.isEmpty() ? 3.0 : calc.parseInput(input2);

            System.out.println("\n=== RESULTS ===");

            // ADDITION with negative value handling
            try {
                System.out.println("Add: " + calc.add(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Add Error: " + e.getMessage());
            }

            // SUBTRACTION with negative value handling
            try {
                System.out.println("Subtract: " + calc.subtract(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Subtract Error: " + e.getMessage());
            }

            // MULTIPLICATION with negative value handling
            try {
                System.out.println("Multiply: " + calc.multiply(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Multiply Error: " + e.getMessage());
            }

            // DIVISION with zero division handling
            try {
                System.out.println("Divide: " + calc.divide(a, b));
            } catch (ZeroDivisionException e) {
                System.out.println("Divide Error: " + e.getMessage());
            }

        } 
        // Handles invalid number format (letters, symbols, etc.)
        catch (InvalidNumberFormatException e) {
            System.out.println("Input Error: " + e.getMessage());
        } 
        // Handles any unexpected runtime errors
        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        } 
        finally {
            scanner.close();
            System.out.println("\nProgram ended.");
        }
    }
}

/*
1. How did you organize your packages?
- I created multiple folders to make it more cleaner and more convenient.

2. Why did you separate your classes this way?
- To make it more organized.

3. How do packages improve encapsulation?
- Packages group related code together and control access, so other parts of the program can’t easily interfere with how things work.

4. Where are your exceptions located?
- All custom exceptions are placed in:
- com.calculator.mance.exceptions

5. Why did you choose Maven or Gradle?
- I used Gradle because it’s simple, flexible, and builds projects quickly, making it beginner-friendly and easy to work with.
*/