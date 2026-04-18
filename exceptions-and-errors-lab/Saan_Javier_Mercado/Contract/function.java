

public abstract class function {
    
    public abstract double add (double a, double b); 
    public abstract double subtract (double a, double b); 
    public abstract double multiply (double a, double b); 
    public abstract double division (double a, double b); // a / b, can throw DivisionByZeroException
    public abstract double modulo (double a, double b); // a % b, can throw DivisionByZeroException
    public abstract double power (double a, double b); // a ^ b (exponentiation)
    
    // Unary operations
    public abstract double squareRoot (double a); // sqrt(a), can throw NegativeNumberException
    public abstract double factorial (double a); // a!, can throw NegativeNumberException or FactorialException
    public abstract double logarithm (double a); // log(a), can throw NegativeNumberException or LogarithmException
    public abstract double sine (double a); // sin(a)
    public abstract double cosine (double a); // cos(a)
    public abstract double tangent (double a); // tan(a), can throw UndefinedTangentException




}
