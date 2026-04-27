/*
*Created by Tismo, Yvette Germaine E.

* How did you organize your packages?
    - I created 3 packages that have different responsibilities so that it is easier to find and it is more organized
        - com.calculator.tismo.main → contains the main class (CalculatorDemo_JHY) that runs the program
        - com.calculator.tismo.service → contains the Calculator class where all operations and logic are implemented
        - com.calculator.tismo.exception → contains custom exception classes

* Why did you separate your classes this way?
    - So that it is easier to understand and find the files based on its responsibilities

* How do packages improve encapsulation?
    - Packages improve encapsulation by grouping related classes and controlling access through the use of access modifiers

* Where are your exceptions located?
    - My exceptions are located on the package named com.calculator.tismo.exceptions

* Why did you choose Maven or Gradle?
    - I choose Gradle because it seemed easier to use and understand. Also because it is faster and more flexible than Maven

*/

package com.calculator.tismo.main;

import com.calculator.tismo.exception.DivisionByZeroException;
import com.calculator.tismo.exception.InvalidInputException;
import com.calculator.tismo.exception.NegativeNumberException;
import com.calculator.tismo.service.Calculator;

public class CalculatorDemo_Tismo {
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
