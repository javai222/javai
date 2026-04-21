package Models;

public abstract class OperatorsAbs {

    // ADDITION
    public abstract int add(int a, int b);
    public abstract double add(double a, double b);

    // SUBTRACTION
    public abstract int subtract(int a, int b);
    public abstract double subtract(double a, double b);

    // MULTIPLICATION
    public abstract int multiply(int a, int b);
    public abstract double multiply(double a, double b);

    // DIVISION
    public abstract int divide(int a, int b) throws Exception;
    public abstract double divide(double a, double b) throws Exception;
}