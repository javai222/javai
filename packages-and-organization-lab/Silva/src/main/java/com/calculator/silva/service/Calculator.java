package com.calculator.silva.service;

import com.calculator.silva.exceptions.DivisionByZeroException;
import com.calculator.silva.exceptions.InvalidInputException;
import com.calculator.silva.exceptions.NegativeNumbersException;
import com.calculator.silva.service.OperatorsAbs;

public class Calculator extends OperatorsAbs {

    public double checkValidity(String input) throws InvalidInputException {
    try {
        return Double.parseDouble(input);
    } catch (NumberFormatException val) {
        throw new InvalidInputException("Invalid input! Only numbers are allowed.");
    }
  }

    // simple validation
    private void checkNegative(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeNumbersException("Negative numbers are not allowed.");
        }
    }

    @Override
    public double add(double a, double b) {
        checkNegative(a,b);
        return a + b;
    }

    @Override
    public int add(int a, int b) {
        checkNegative(a,b);
        return a + b;
    }
    
    @Override
    public double subtract(double a, double b) {
        checkNegative(a, b);
        return a - b;
    }

    @Override
    public int subtract(int a, int b) {
        checkNegative(a,b);
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        checkNegative(a, b);
        return a * b;
    }

    @Override
    public int multiply(int a, int b) {
        checkNegative(a, b);
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        checkNegative(a, b);

        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }

        return a / b;
    }

    @Override
    public int divide(int a, int b) {
        checkNegative(a, b);

        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }

        return a / b;
    }
}