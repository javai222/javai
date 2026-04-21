package models;

import exceptions.ZeroDivisionException;
import exceptions.InvalidNumberFormatException;
import exceptions.NegativeValueException;

public class Calculator extends OperatorsAbs {

    // VALIDATION: convert string safely (optional use for demo input)
    public double parseInput(String input) throws InvalidNumberFormatException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException("Input must be a valid number.");
        }
    }

    // CHECK NEGATIVE NUMBERS
    private void checkNegative(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeValueException("Negative values are not allowed.");
        }
    }

    // ADD
    @Override
    public int add(int a, int b) {
        checkNegative(a, b);
        return a + b;
    }

    @Override
    public double add(double a, double b) {
        checkNegative(a, b);
        return a + b;
    }

    // SUBTRACT
    @Override
    public int subtract(int a, int b) {
        checkNegative(a, b);
        return a - b;
    }

    @Override
    public double subtract(double a, double b) {
        checkNegative(a, b);
        return a - b;
    }

    // MULTIPLY
    @Override
    public int multiply(int a, int b) {
        checkNegative(a, b);
        return a * b;
    }

    @Override
    public double multiply(double a, double b) {
        checkNegative(a, b);
        return a * b;
    }

    // DIVIDE
    @Override
    public int divide(int a, int b) throws ZeroDivisionException {
        if (b == 0) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        checkNegative(a, b);
        return a / b;
    }

    @Override
    public double divide(double a, double b) throws ZeroDivisionException {
        if (b == 0.0) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        checkNegative(a, b);
        return a / b;
    }
}