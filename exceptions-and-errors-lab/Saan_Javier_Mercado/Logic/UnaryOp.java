package Logic;

import Contract.unaryOp;
import Exception.FactorialExceptions;
import Exception.LogarithmException;
import Exception.UndefinedTangentException;
import Exception.NegativeNumberException;

public class UnaryOp extends unaryOp {
    

    @Override
    // Returns the square root of a number.
    public double squareRoot(double a) {
        if (a < 0)
            throw new NegativeNumberException("Cannot take square root of a negative number");
        return Math.sqrt(a);
    }

    @Override
    // Returns the factorial of a non-negative integer value.
    public double factorial(double a) throws FactorialExceptions {
        if (a < 0)
            throw new FactorialExceptions("Cannot take factorial of a negative number");
        if (a != (int) a)
            throw new FactorialExceptions("Cannot take factorial of a non-integer");
        double result = 1;
        for (int i = 1; i <= (int) a; i++) {
            result *= i;
        }
        return result;
    }

    @Override
    // Returns the natural logarithm (base e).
    public double logarithm(double a) throws LogarithmException {
        if (a <= 0)
            throw new LogarithmException("Cannot take logarithm of non-positive numbers");
        return Math.log(a);
    }

    // Overload: accepts integer input for natural logarithm.
    public int logarithm(int a) throws LogarithmException {
        if (a <= 0)
            throw new LogarithmException("Cannot take logarithm of non-positive numbers");
        return (int) Math.log(a);
    }

    // Overload: computes logarithm with a custom base.
    public double logarithm(double a, double base) throws LogarithmException {
        if (a <= 0 || base <= 0 || base == 1)
            throw new LogarithmException("Invalid input for logarithm");
        return Math.log(a) / Math.log(base);
    }

    @Override
    // Returns the sine of an angle (in radians).
    public double sine(double a) {
        return Math.sin(a);
    }

    // Overload: accepts integer input for sine.
    public int sine(int a) { 

        return (int) Math.sin(a);
    }

    @Override
    // Returns the cosine of an angle (in radians).
    public double cosine(double a) {
        return Math.cos(a);
    }

    // Overload: accepts integer input for cosine.
    public int cosine(int a) {
        return (int) Math.cos(a);
    }

    @Override
    // Returns the tangent of an angle (in radians).
    public double tangent(double a) throws UndefinedTangentException {
        if (Math.cos(a) == 0)
            throw new UndefinedTangentException("Tangent is undefined at this angle");
        return Math.tan(a);
    }

    // Overload: accepts integer input for tangent.
    public int tangent(int a) throws UndefinedTangentException {
        if (Math.cos(a) == 0)
            throw new UndefinedTangentException("Tangent is undefined at this angle");
        return (int) Math.tan(a);
    }
}