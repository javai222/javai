package com.calculator.mance.service;

import com.calculator.mance.exceptions.InvalidNumberFormatException;
import com.calculator.mance.exceptions.NegativeValueException;
import com.calculator.mance.exceptions.ZeroDivisionException;

// Calculator class that implements all abstract operations
// and handles validation rules (negative numbers, invalid input, division by zero)
public class CalculatorService implements Operations {

    // Converts string input into a numeric (double) value
    // Throws exception if input is not a valid number
    public double parseInput(String input) throws InvalidNumberFormatException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberFormatException("Input must be a valid number.");
        }
    }

    // Checks if inputs contain negative values
    // Used before performing any arithmetic operation
    private void checkNegative(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeValueException("Negative values are not allowed.");
        }
    }

    // ADDITION
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

    // SUBTRACTION
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

    // MULTIPLICATION
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

    // DIVISION (INT)
    // Prevents division by zero and checks negative values
    @Override
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        checkNegative(a, b);
        return a / b;
    }

    // DIVISION (DOUBLE)
    @Override
    public double divide(double a, double b) {
        if (b == 0.0) {
            throw new ZeroDivisionException("Cannot divide by zero.");
        }
        checkNegative(a, b);
        return a / b;
    }
}
