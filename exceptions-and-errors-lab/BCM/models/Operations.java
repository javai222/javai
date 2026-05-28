package models;

// Abstract class defining calculator operations
public abstract class Operations {

    public abstract int add(int a, int b);
    public abstract double add(double a, double b);

    public abstract int subtract(int a, int b);
    public abstract double subtract(double a, double b);

    public abstract int multiply(int a, int b);
    public abstract double multiply(double a, double b);

    // FIX: keep consistency (NO throws, since your runtime exceptions handle errors)
    public abstract int divide(int a, int b);
    public abstract double divide(double a, double b);
}
