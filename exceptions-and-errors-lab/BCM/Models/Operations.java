package Models;

import exceptions.ZeroDivisionException;
import exceptions.InvalidNumberFormatException;
import exceptions.NegativeValueException;

public class Calculator extends OperatorsAbs {

    // Converts a string input into a double value.
    // Throws an exception if the input is not a valid number format.
    public double parseInput(String input) throws InvalidNumberFormatException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException("Input must be a valid number.");
        }
    }

    // Validates that both inputs are not negative.
    // Used before performing any arithmetic operation.
    private void checkNegative(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeValueException("Negative values are not allowed.");
        }
    }

    // Performs addition after validation
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

    // Performs subtraction after validation
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

    // Performs multiplication after validation
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

    // Performs division with safety checks
    // Ensures divisor is not zero and inputs are not negative
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