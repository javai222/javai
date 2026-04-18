package Models;

import Exceptions.DivisionByZeroException;
import Exceptions.InvalidInputValuesException;
import Exceptions.NegativeNumbersException;

public class Calculator extends OperatorsAbs {

    // simple validation
    private void checkNegative(int a, int b) {
        if (a < 0 || b < 0) {
            throw new NegativeNumbersException("Negative numbers are not allowed.");
        }
    }

    @Override
    public double add(int a, int b) {
        checkNegative(a, b);
        return a + b;
    }

    // METHOD OVERLOADING
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(int a, int b) {
        checkNegative(a, b);
        return a - b;
    }

    @Override
    public double multiply(int a, int b) {
        checkNegative(a, b);
        return a * b;
    }

    @Override
    public double divide(int a, int b) {
        checkNegative(a, b);

        if (b == 0) {
            throw new DivisionByZeroException("Cannot divide by zero.");
        }

        return (double) a / b;
    }
}