// created by Casapao, Dolormente, and Tismo
package model;

public abstract class OperatorAbs {
    // abstract method for addition
    protected abstract int add(int a, int b);
    protected abstract double add(double a, double b);

    // abstract method for subtraction
    protected abstract int subtract(int a, int b);
    protected abstract double subtract(double a, double b);

    // abstract method for multiplication
    protected abstract int multiply(int a, int b);
    protected abstract double multiply(double a, double b);

    // abstract method for division and to handle the invalid input
    protected abstract double divide(double a, double b) throws InvalidInputException;
}
