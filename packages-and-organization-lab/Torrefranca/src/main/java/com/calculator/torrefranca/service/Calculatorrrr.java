package com.calculator.torrefranca.exception;

import com.calculator.torrefranca.exception.DiviByZero;
import com.calculator.torrefranca.exception.InputInvaliddException;
import com.calculator.torrefranca.exception.NegativeNum;

public class Calculatorrrr extends Operations {

    // PARSE INPUT
    public double parseInput(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InputInvaliddException("Invalid number format.");
        }
    }

    // VALIDATION
    private void validate(double a, double b) {
        if (a < 0 || b < 0) {
            throw new NegativeNum("Negative numbers are not allowed.");
        }
    }

    @Override
    public double add(double a, double b) {
        validate(a, b);
        return super.add(a, b);
    }

    @Override
    public double subtract(double a, double b) {
        validate(a, b);
        return super.subtract(a, b);
    }

    @Override
    public double multiply(double a, double b) {
        validate(a, b);
        return super.multiply(a, b);
    }

    @Override
    public double divide(double a, double b) {

        if (b == 0) {
            throw new DiviByZero("Cannot divide by zero.");
        }

        validate(a, b);
        return super.divide(a, b);
    }
}
