package model;

import exceptions.InvalidInputException;
import exceptions.NegativeNumbertException;
import exceptions.DivisionByZeroException;

public class Calculator extends Operations {

    // Parse string input to number
    public double parseInput(String input) throws InvalidNumberFormatException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Input must be a valid number.");
        }
    }

    // VALIDATION: negative numbers
    private void checkNegative(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeNumberException("Negative values are not allowed.");
        }
    }

    // ADD
    @Override
    public double add(double a, double b) {
        checkNegative(a, b);
        return super.add(a, b);
    }

    // SUBTRACT
    @Override
    public double subtract(double a, double b) {
        checkNegative(a, b);
        return super.subtract(a, b);
    }

    // MULTIPLY
    @Override
    public double multiply(double a, double b) {
        checkNegative(a, b);
        return super.multiply(a, b);
    }

    // DIVIDE (MAIN EXCEPTION POINT)
    @Override
    public double divide(double a, double b) {

        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }

        checkNegative(a, b);

        return super.divide(a, b);
    }
}
