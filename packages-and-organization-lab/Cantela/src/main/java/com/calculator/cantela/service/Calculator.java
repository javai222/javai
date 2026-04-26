/*Created by Cantela, Chris Nelson B.
 * Calculator class - Performs arithmetic operations and handles input parsing
 * Extends Operators abstract class, implements 8 operators: +, -, *, /, %, ^, sqrt, factorial
 * Throws custom exceptions for invalid input, division by zero, negative numbers, and factorial errors
 */

package com.calculator.cantela.service;

import com.calculator.cantela.exceptions.*;

// Concrete implementation of Operators - provides all arithmetic operations
public class Calculator extends Operators {
    static boolean isParsing = false;

    // Parses string to double, throws InvalidInputException if parsing fails
    public double parseExpression (String input) throws InvalidInputException{
        try {
            double parseValue = Double.parseDouble(input);
                isParsing = true;
            return parseValue;
        } catch (NumberFormatException nfe) {
            // Catch NumberFormatException and throw our custom checked exception
            throw new InvalidInputException("Invalid input, enter a numeric digit");
        }
    }


    // Basic arithmetic operations - no exception handling needed
    @Override
    protected double add(double a, double b) {
        return a + b;
    }

    @Override
    protected double subtract(double a, double b) {
        return a - b;
    }

    @Override
    protected double multiply(double a, double b) {
        return a * b;
    }

    // Throws DivisionByZeroException if divisor is 0
    @Override
    protected double division(double a, double b) {
        if (b == 0)
            throw new DivisionByZerosException("Cannot divide by 0");
        return a / b;
    }

    // Throws DivisionByZeroException if divisor is 0
    @Override
    protected double modulo(double a, double b) {
        if (b == 0)
            throw new DivisionByZerosException("Cannot modulo by zero");
        return a % b;
    }

    @Override
    protected double power(double a, double b) {
        return Math.pow(a, b);
    }

    // Throws NegativeNumberException if input is negative
    @Override
    protected double squareRoot(double a) {
        if (a < 0)
            throw new NegativeNumberException("Cannot square root a negative number");
        return Math.sqrt(a);
    }

    // Recursive factorial - throws NegativeNumberException or FactorialException for invalid input
    @Override
    protected double factorial(double a) {
        // Check 1: Negative numbers not allowed
        if (a < 0)
            throw new NegativeNumberException("Cannot factor a negative number");

        // Check 2: Maximum value is 170 (limits double overflow)
        if (a > 170)
            throw new FactorialException("Number too large for factorial max is 170");

        // Check 3: Only integers allowed
        if (a != Math.floor(a))
            throw new FactorialException("Factorial only works for integers");

        // Base case
        if (a == 0 || a == 1)
            return 1;

        // Recursive call
        return a * factorial(a - 1);
    }

    @Override   //Throws NegativeNumberException if input is negative
    protected double logarithm(double a) {
       if (a <= 0)
           throw new NegativeNumberException("Logarithm is only for positive numbers");

        return Math.log(a);
    }

    @Override   //For sin and cosine no exceptions needed since they are defined for all real numbers
    protected double sine(double a) {       
        return Math.sin(a);
    }

    @Override
    protected double cosine(double a) {
        return Math.cos(a);
    }

    @Override   //Throws UndefinedPointsException if cos(a) ≈ 0 (odd multiples of π/2 radians, e.g., 90°, 270°)
    protected double tangent(double a) {
        if (Math.abs(Math.cos(a)) < 1e-12)
            throw new UndefinedPointsException("Tangent is undefined when cos(a) = 0 (odd multiples of 90° or π/2).");

        return Math.tan(a);
    }

    //Overloaded methods for int parameters - provide integer-specific operations
    protected double add (int a, int b) {
        return a + b;
    }

    protected double subtract (int a, int b) {
        return a - b;
    }

    protected double multiply (int a, int b) {
        return a * b;
    }

    protected double division (int a, int b) {
        if (b == 0)
            throw new DivisionByZerosException("Cannot divide by 0");

        return (double) a / b;
    }

        //Parses and executes unary operations, throws InvalidInputException for invalid format or operator
    public double unaryOperation (String input) throws InvalidInputException {
        String[] expression = input.trim().split("\\s+");                                                                                                                                   if (expression.length != 2)
            throw new InvalidInputException("Invalid expression format, please follow the said format");

        // Check if the format is factorial: number !
        if (expression[1].equalsIgnoreCase("!")) {
            double number = parseExpression(expression[0]);
            return factorial(number);
        }

        // Otherwise, treat as prefix operator: operator number
        String operator = expression[0];
        double right = parseExpression(expression[1]);

        switch (operator.toLowerCase()) {
            case "sqrt", "sqr":
                return squareRoot(right);
            case "log":
                return logarithm(right);
            case "sin", "sine":
                return sine(right);
            case "cos", "cosine":
                return cosine(right);
            case "tan":
                return tangent(right);
            default:
                throw new InvalidInputException("Invalid unary operator");
        }
    }



    // Parse and execute binary operations, throws InvalidInputException or DivisionByZeroException
    public double operation (String input) throws InvalidInputException {
        String[] expression = input.trim().split("\\s+");
        // Expected format: "NUMBER OPERATOR NUMBER"
        if (expression.length != 3)
            throw new InvalidInputException("Invalid expression format, please follow the said format");

        // Parse operands - can throw InvalidInputException
        double left = parseExpression(expression[0]);
        String operator = expression[1];
        double right = parseExpression(expression[2]);

        // Execute operation based on operator type
        switch (operator) {
            case "+" : return add(left, right);
            case "-" : return subtract(left, right);
            case "*" : return multiply(left, right);
            case "/" : return division(left, right); // Can throw DivisionByZeroException
            case "%" : return modulo(left, right); // Can throw DivisionByZeroException
            case "^" : return power(left, right);
            default  : throw new InvalidInputException("Invalid operator, try again");
        }
    }

}