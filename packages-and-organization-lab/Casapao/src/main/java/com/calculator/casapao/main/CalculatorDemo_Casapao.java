/*
* How did you organize your packages?
* I organize it by creating a package for the main class, a package for the service class, and a package for the custom exceptions.
* Why did you separate your classes this way?
* I separated the classes this way to improve modularity and maintainability. By organizing the classes into different packages based on their functionality, it becomes easier to manage and understand the codebase. The main class is responsible for demonstrating the calculator's functionality, the service class contains the core logic for the calculator operations, and the exceptions package contains custom exceptions that can be thrown when invalid inputs or operations occur. This separation allows for better encapsulation and makes it easier to locate and modify specific parts of the code when needed.
* How do packages improve encapsulation?
* Packages improve encapsulation by grouping related classes together and controlling access to them. By placing classes in different packages, you can restrict access to certain classes or members using access modifiers (e.g., public, private, protected). This allows you to hide implementation details and only expose the necessary interfaces to other parts of the code. It also helps prevent naming conflicts and promotes better organization of the codebase.
* Where are your exceptions located?
* The exceptions are located in the "exception" package, which contains custom exception classes such as InvalidInputException, DivisionByZeroException, and NegativeNumberException.
* Why did you choose Maven or Gradle?
* I chose Gradle because it provides a more flexible and powerful build system compared to Maven. Gradle allows for easier configuration and customization of the build process, and it has better support for multi-project builds. Additionally, Gradle's incremental build feature can significantly reduce build times, which is beneficial for larger projects. Overall, I found Gradle to be more efficient and user-friendly for managing dependencies and building the project.
*/

package com.calculator.casapao.main;

import com.calculator.casapao.exception.DivisionByZeroException;
import com.calculator.casapao.exception.InvalidInputException;
import com.calculator.casapao.exception.NegativeNumberException;
import com.calculator.casapao.service.Calculator;

public class CalculatorDemo_Casapao {
    public static void main (String [] args){
        Calculator cal = new Calculator();// Initialization of calculator

        System.out.println("=== CALCULATOR DEMO ===\n");
        // Adding valid inputs
        try {
            double num1 = cal.getValidNumber ("16");
            double num2 = cal.getValidNumber ("67");

            double result = cal.add(num1,num2);
            System.out.println("Sum: " + result);
            
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
            
        } finally {
            System.out.println("Addition operation attempted.");
        }
        
         System.out.println();
        // Subtracting valid inputs
        try {
            double num1 = cal.getValidNumber ("6.8");
            double num2 = cal.getValidNumber ("2.5");

            double result = cal.subtract(num1,num2);
            System.out.println("Difference: " + result);
            
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
            
        } finally {
            System.out.println("Subtraction operation attempted.");
        }

         System.out.println();
        // multiplying valid inputs
        try {
            double num1 = cal.getValidNumber ("11");
            double num2 = cal.getValidNumber ("2");

            double result = cal.multiply(num1,num2);
            System.out.println("Product: " + result);
            
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
            
        } finally {
            System.out.println("Multiplication operation attempted.");
        }

        System.out.println();
        // Dividing valid inputs
        try {
            double num1 = cal.getValidNumber("25");
            double num2 = cal.getValidNumber("10");

            double result = cal.divide(num1, num2);
            System.out.println("Quotient: " + result);

        } catch (DivisionByZeroException divzero) {
            System.out.println("Unchecked Exception: " + divzero.getMessage());
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }    
        finally {
            System.out.println("Division operation attempted.");
        }

        System.out.println();
        // Testing invalid input (checked exception)
        try {
            double num = cal.getValidNumber("abc"); // Invalid
            System.out.println("Parsed number: " + num);

        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }

        System.out.println();
        //testing negative number (unchecked exception)
        try {
            double num = cal.getValidNumber("-5");
            cal.checkNegative(num);

        } catch (NegativeNumberException negnum) {
            System.out.println("Unchecked Exception: " + negnum.getMessage());
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }
        
        System.out.println();
        // testing division by 0
        try {
            double num1 = cal.getValidNumber("10");
            double num2 = cal.getValidNumber("0");

            double result = cal.divide(num1, num2); // triggers exception
            System.out.println("Quotient: " + result);

        } catch (DivisionByZeroException divzero) {
            System.out.println("Unchecked Exception: " + divzero.getMessage());
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }    
        finally {
            System.out.println("Division operation attempted.");
        }
    }
}
