package com.calculator.saan.contract;

import com.calculator.saan.exception.factorialExceptions;
import com.calculator.saan.exception.logarithmException;
import com.calculator.saan.exception.undefinedTangentException;

// Defines the unary calculator operations used by the implementation classes.
public abstract class unaryOp {

    // Returns the square root of the given value.
    public abstract double squareRoot(double a);

    // Returns the factorial of the given value.
    public abstract double factorial(double a) throws factorialExceptions, factorialExceptions;

    // Returns the logarithm of the given value.
    public abstract double logarithm(double a) throws logarithmException;

    // Returns the sine of the given value.
    public abstract double sine(double a);

    // Returns the cosine of the given value.
    public abstract double cosine(double a);

    // Returns the tangent of the given value.
    public abstract double tangent(double a) throws undefinedTangentException;
}
