// created by Casapao, Dolormente, and Tismo
package calculator;

public abstract class OperatorAbs {
    // abstract method for addition
    public abstract int add(int a, int b);
    public abstract double add(double a, double b);

    // abstract method for subtraction
    public abstract int subtract(int a, int b);
    public abstract double subtract(double a, double b);

    // abstract method for multiplication
    public abstract int multiply(int a, int b);
    public abstract double multiply(double a, double b);

    // abstract method for division and to handle the invalid input
    public abstract double divide(double a, double b) throws InvalidInputException;
}
