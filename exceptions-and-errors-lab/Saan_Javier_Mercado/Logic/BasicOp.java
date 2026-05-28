package Logic;

import Exception.Divisionbyzero;
import Contract.basicOp;

public class BasicOp extends basicOp {

    @Override
    // Returns the sum of two decimal numbers.
    public double add(double a, double b ) {
        return a + b;
    }

    // Overload: returns the sum of two integers.
    public int add(int a, int b) {
        return a + b;
    }

    // Overload: returns the sum of three decimal numbers.
    public double add(double a, double b, double c) {
        return a + b + c;
    }

    // Overload: returns the sum of multiple decimal numbers.
    public double add(double... numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum;
    }

    @Override
    // Returns the difference of two decimal numbers.
    public double subtract(double a, double b) {
        return a - b;
    }

    // Overload: returns the difference of two integers.
    public int subtract(int a, int b) {
        return a - b;
    }

    // Overload: subtracts three decimal numbers in sequence.
    public double subtract(double a, double b, double c) {
        return a - b - c;
    }

    @Override
    // Returns the product of two decimal numbers.
    public double multiply(double a, double b) {
        return a * b;
    }

    // Overload: returns the product of two integers.
    public int multiply(int a, int b) {
        return a * b;
    }

    // Overload: returns the product of three decimal numbers.
    public double multiply(double a, double b, double c) {
        return a * b * c;
    }

    // Overload: returns the product of multiple decimal numbers.
    public double multiply(double... numbers) {
        double product = 1;
        for (double number : numbers) {
            product *= number;
        }
        return product;
    }

    @Override
    // Returns the quotient of two decimal numbers.
    public double division(double a, double b) throws Divisionbyzero {
        if (b == 0) {
            throw new Divisionbyzero("Cannot divide by zero");
        }
        return a / b;
    }

    // Overload: divides two integers.
    public int division(int a, int b) throws Divisionbyzero {
        if (b == 0) {
            throw new Divisionbyzero("Cannot divide by zero");
        }
        return a / b;
    }

    // Overload: divides three decimal numbers in sequence.
    public double division(double a, double b, double c) throws Divisionbyzero {
        if (b == 0 || c == 0) {
            throw new Divisionbyzero("Cannot divide by zero");
        }
        return a / b / c;
    }

    @Override
    // Returns the remainder of two decimal numbers.
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot modulo by zero");
        }
        return a % b;
    }

    // Overload: returns the remainder of two integers.
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot modulo by zero");
        }
        return a % b;
    }

    // Overload: applies modulo in sequence for three decimal numbers.
    public double modulo(double a, double b, double c) {
        if (b == 0 || c == 0) {
            throw new ArithmeticException("Cannot modulo by zero");
        }
        return (a % b) % c;
    }

    @Override
    // Returns a raised to the power of b.
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Overload: returns the square of a decimal number.
    public double power(double a) {
        return Math.pow(a, 2);
    }

    // Overload: returns integer power result.
    public int power(int a, int b) {
        return (int) Math.pow(a, b);
    }

}