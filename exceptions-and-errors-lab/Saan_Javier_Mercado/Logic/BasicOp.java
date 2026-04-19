package Logic;

import Exception.Divisionbyzero;
import Contract.basicOp;

public class BasicOp extends basicOp {

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    // Checked: callers must handle this or declare it.
    public double division(double a, double b) throws Divisionbyzero {
        if (b == 0) {
            throw new Divisionbyzero("Cannot divide by zero");
        }
        return a / b;
    }

    @Override
    // Unchecked: can be thrown at runtime without being declared.
    public double modulo(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot modulo by zero");
        }
        return a % b;
    }

    @Override
    public double power(double a, double b) {
        return Math.pow(a, b);
    }

}