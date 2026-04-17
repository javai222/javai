/* 
* Created by Casapao, Jasmin Ann M. | Dolormente, Henry II S. | Tismo, Yvette Germaine E.
* 
* 
* What exceptions did you create?
* Which are checked vs unchecked?
* Where are exceptions thrown?
* Where are they handled?
* Where does propagation occur?
* How did you apply OOP concepts?
*/

package Demo;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
import model.Calculator;

public class CalculatorDemo_JHY {
    public static void main (String [] args){
        Calculator cal = new Calculator();// initialization of calculator

        System.out.println("=== CALCULATOR DEMO ===\n");
        // adding valid inputs
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
        // subtracting valid inputs
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
        // dividing valid inputs
        try {
            double num1 = cal.getValidNumber("25");
            double num2 = cal.getValidNumber("10");

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

        System.out.println();
        // testing invalid input (checked exception)
        try {
            double num = cal.getValidNumber("abc"); // invalid
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
