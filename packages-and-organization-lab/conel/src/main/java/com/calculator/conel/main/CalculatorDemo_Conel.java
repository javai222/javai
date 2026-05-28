  // Author: Conel, Rahzel Heeroe R.

/*
1. **How did you organize your packages?**
   I organized my packages based on their purpose. The model package contains the abstract class, the service package handles the calculator functions, the exceptions package contains the custom exceptions, and the main package is for the user input and program execution.

2. **Why did you separate your classes this way?**
   I separated my classes so each one has its own responsibility. This makes the code more organized, easier to understand, and easier to maintain.

3. **How do packages improve encapsulation?**
   Packages improve encapsulation by grouping related classes together and controlling access to certain parts of the program. This helps keep the code secure and organized.

4. **Where are your exceptions located?**
   My custom exceptions are located in the `com.calculator.balanon.exceptions` package.

5. **Why did you choose Maven or Gradle?**
   I chose Gradle because it is easy to use, flexible, and helps make building and running the project faster and more efficient.

*/

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

