//Created by Cantela, Chris Nelson B.
package models;

// Abstract class defining contract for all arithmetic operations
public abstract class Operators {

    // Basic binary operations
    protected abstract double add (double a, double b); 
    protected abstract double subtract (double a, double b); 
    protected abstract double multiply (double a, double b); 
    protected abstract double division (double a, double b); // a / b, can throw DivisionByZeroException
    protected abstract double modulo (double a, double b); // a % b, can throw DivisionByZeroException
    protected abstract double power (double a, double b); // a ^ b (exponentiation)
    
    // Unary operations
    protected abstract double squareRoot (double a); // sqrt(a), can throw NegativeNumberException
    protected abstract double factorial (double a); // a!, can throw NegativeNumberException or FactorialException
}
