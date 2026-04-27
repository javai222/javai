 // Class Created by Mance, John Roque R.

package com.calculator.conel.main;

import java.util.Scanner;

import com.calculator.conel.exceptions.InvalidNumberFormatException;
import com.calculator.conel.exceptions.NegativeValueException;
import com.calculator.conel.exceptions.ZeroDivisionException;
import com.calculator.conel.service.CalculatorService;


public class CalculatorDemo_Conel {
    public static void main(String[] args) {

        CalculatorService calc = new CalculatorService();
        Scanner scanner = new Scanner(System.in);

        try {
            // INPUT 1: first number from user
            System.out.print("Enter first number: ");
            double a = calc.parseInput(scanner.nextLine());

            // INPUT 2: second number from user
            System.out.print("Enter second number: ");
            double b = calc.parseInput(scanner.nextLine());

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
1. EXCEPTIONS CREATED:
- InvalidNumberFormatException
- NegativeValueException
- ZeroDivisionException

2. CHECKED VS UNCHECKED:
- Checked: InvalidNumberFormatException (extends Exception)
- Unchecked: NegativeValueException, ZeroDivisionException (extends RuntimeException)

3. WHERE EXCEPTIONS ARE THROWN:
- InvalidNumberFormatException -> parseInput() when input is not a number
- NegativeValueException -> checkNegative() when value is negative
- ZeroDivisionException -> divide() when divisor is 0

4. WHERE EXCEPTIONS ARE HANDLED:
- CalculatorDemo (main class)
  - InvalidNumberFormatException handled in outer try-catch
  - NegativeValueException handled in each operation try-catch
  - ZeroDivisionException handled in division try-catch

5. WHERE PROPAGATION OCCURS:
- Exceptions are thrown from Calculator class methods
- They propagate to CalculatorDemo unless caught

6. OOP CONCEPTS USED:
- Encapsulation: validation methods inside Calculator class
- Abstraction: Operations abstract class defines methods
- Inheritance: Calculator extends Operations
- Polymorphism: method overloading and overriding
*/
