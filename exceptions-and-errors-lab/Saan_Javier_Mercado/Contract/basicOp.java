package Contract;

import Exception.Divisionbyzero;

public abstract class basicOp {
      
    public abstract double add (double a, double b); 
    public abstract double subtract (double a, double b); 
    public abstract double multiply (double a, double b); 
    // Checked exception: must be declared with throws or caught using try-catch.
    public abstract double division (double a, double b) throws Divisionbyzero;
    // Unchecked exception: RuntimeException type, not required in method signature.
    public abstract double modulo (double a, double b);
    public abstract double power (double a, double b); // a ^ b (exponentiation)
   
}

