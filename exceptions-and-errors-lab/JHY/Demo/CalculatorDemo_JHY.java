/* 
* Created by Casapao, Jasmin Ann M. | Dolormente, Henry II S. | Tismo, Yvette Germaine E.

* What exceptions did you create?
    - We created 3 exceptions DivisionByZeroException, InvalidInputException, and NegativeNumberException
    
* Which are checked vs unchecked?
    - DivisionByZeroException and NegativeNumberException are unchecked exceptions, while InvalidInputException is
      a checked exception
    
* Where are exceptions thrown?
    - DivisionByZeroException – thrown when attempting to divide a number by zero in the divide() method.
    - InvalidInputException – thrown when the user inputs a non-numeric value that cannot be converted into a number
      in the getValidNumber() method.
    - NegativeNumberException – thrown when a negative value is detected in the checkNegative() method.
    
* Where are they handled?
    - Exceptions are handled in the CalculatorDemo_JHY.java (main class) using multiple try catch blocks.
    
* Where does propagation occur?
    - It occurs when exceptions are thrown inside the Calculator.java class are not handled in it. Instead they
      are handled inside the CalculatorDemo_JHY.java (main class) where they are caught using try-catch blocks.
    
* How did you apply OOP concepts?
    - Abstraction: through the use of abstract class that we named as OperatorsAbs.
    - Encapsulation: Usage of access modifiers 
    - Inheritance: The Calculator.java extends the abstract class OperatorsAbs.java
    - Polymorphism: We overloaded the methods by using int and double for add, subtract, multiplication, and 
      division.
*/

package Demo;

import exceptions.DivisionByZeroExceptions;
import exceptions.InvalidInputExceptions;
import exceptions.NegativeNumberExceptions;
import model.CalculatorJHY;

public class CalculatorDemo_JHY {
    public static void main (String [] args){
        CalculatorJHY cal = new CalculatorJHY();// Initialization of calculator

        System.out.println("=== CALCULATOR DEMO ===\n");
        // Adding valid inputs
        try {
            double num1 = cal.getValidNumber ("16");
            double num2 = cal.getValidNumber ("67");

            double result = cal.add(num1,num2);
            System.out.println("Sum: " + result);
            
        } catch (InvalidInputExceptions invinp) {
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
            
        } catch (InvalidInputExceptions invinp) {
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
            
        } catch (InvalidInputExceptions invinp) {
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

        } catch (DivisionByZeroExceptions divzero) {
            System.out.println("Unchecked Exception: " + divzero.getMessage());
        } catch (InvalidInputExceptions invinp) {
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

        } catch (InvalidInputExceptions invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }

        System.out.println();
        //testing negative number (unchecked exception)
        try {
            double num = cal.getValidNumber("-5");
            cal.checkNegative(num);

        } catch (NegativeNumberExceptions negnum) {
            System.out.println("Unchecked Exception: " + negnum.getMessage());
        } catch (InvalidInputExceptions invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }
        
        System.out.println();
        // testing division by 0
        try {
            double num1 = cal.getValidNumber("10");
            double num2 = cal.getValidNumber("0");

            double result = cal.divide(num1, num2); // triggers exception
            System.out.println("Quotient: " + result);

        } catch (DivisionByZeroExceptions divzero) {
            System.out.println("Unchecked Exception: " + divzero.getMessage());
        } catch (InvalidInputExceptions invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }    
        finally {
            System.out.println("Division operation attempted.");
        }
    }
}
