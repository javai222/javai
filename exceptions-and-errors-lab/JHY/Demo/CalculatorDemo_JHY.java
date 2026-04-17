package Demo;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;
import model.Calculator;

public class CalculatorDemo_JHY {
    public static void main (String [] args){
        Calculator cal = new Calculator();

        System.out.println("=== CALCULATOR DEMO ===\n");
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
    }
}
