package com.calculator.saan.contract;

import com.calculator.saan.exception.divisionbyzero;

// Defines the basic arithmetic operations for the calculator.
public abstract class basicOp {
      
    // Returns the sum of two values.
    public abstract double add (double a, double b); 
    // Returns the difference of two values.
    public abstract double subtract (double a, double b); 
    // Returns the product of two values.
    public abstract double multiply (double a, double b); 
    // Checked exception: must be declared with throws or caught using try-catch.
    // Returns the quotient of two values.
    public abstract double division (double a, double b) throws divisionbyzero;
    // Unchecked exception: RuntimeException type, not required in method signature.
    // Returns the remainder of two values.
    public abstract double modulo (double a, double b);
    // Returns the result of raising the first value to the second value.
    public abstract double power (double a, double b); // a ^ b (exponentiation)
   
}

