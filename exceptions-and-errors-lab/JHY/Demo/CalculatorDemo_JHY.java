package Demo;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
import model.Calculator;

public class CalculatorDemo_JHY {
    public static void main (String [] args){
        Calculator cal = new Calculator();

        System.out.println("=== CALCULATOR DEMO ===\n");
        // adding valid inputs
        try {
            double num1 = cal.getValidNumber ("16");
            double num2 = cal.getValidNumber ("67");

            double result = cal.add(num1,num2);
            System.out.println("Addition Result: " + result);
            
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
            
        } finally {
            System.out.println("Addition operation attempted.");
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
            calc.checkNegative(num);

        } catch (NegativeNumberException negnum) {
            System.out.println("Unchecked Exception: " + negnum.getMessage());
        } catch (InvalidInputException invinp) {
            System.out.println("Checked Exception: " + invinp.getMessage());
        }
        
        System.out.println();
        // testing division by 0
        try {
            double num1 = calc.getValidNumber("10");
            double num2 = calc.getValidNumber("0");

            double result = calc.divide(num1, num2); // triggers exception
            System.out.println("Division Result: " + result);

        } catch (DivisionByZeroException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        } catch (InvalidInputException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        }    
        finally {
            System.out.println("Division operation attempted.");
        }
    }
}
