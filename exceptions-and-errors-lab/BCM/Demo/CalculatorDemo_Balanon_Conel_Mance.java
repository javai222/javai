// Class Created by Mance, John Roque R.

package Demo;

import java.util.Scanner;

import exceptions.InvalidNumberFormatException;
import exceptions.NegativeValueException;
import exceptions.ZeroDivisionException;
import Models.Calculator;

public class CalculatorDemo_Balanon_Conel_Mance {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // INPUT 1
            System.out.print("Enter first number: ");
            String input1 = scanner.nextLine();
            double a = calc.parseInput(input1);

            // INPUT 2
            System.out.print("Enter second number: ");
            String input2 = scanner.nextLine();
            double b = calc.parseInput(input2);

            System.out.println("\n=== RESULTS ===");

            // ADD
            try {
                System.out.println("Add: " + calc.add(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Add Error: " + e.getMessage());
            }

            // SUBTRACT
            try {
                System.out.println("Subtract: " + calc.subtract(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Subtract Error: " + e.getMessage());
            }

            // MULTIPLY
            try {
                System.out.println("Multiply: " + calc.multiply(a, b));
            } catch (NegativeValueException e) {
                System.out.println("Multiply Error: " + e.getMessage());
            }

            // DIVIDE
            try {
                System.out.println("Divide: " + calc.divide(a, b));
            } catch (ZeroDivisionException e) {
                System.out.println("Divide Error: " + e.getMessage());
            }
        }

        catch (InvalidNumberFormatException e) {
            System.out.println("Input Error: " + e.getMessage());
        }

        catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }

        finally {
            scanner.close();
            System.out.println("\nProgram ended.");
        }

    }
}