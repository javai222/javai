/*Created by Cantela, Chris Nelson B.
 * Calculator class - Performs arithmetic operations and handles input parsing
 * Extends Operators abstract class, implements 8 operators: +, -, *, /, %, ^, sqrt, factorial
 * Throws custom exceptions for invalid input, division by zero, negative numbers, and factorial errors
 */

package models;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.FactorialException;
import exceptions.NegativeNumberException;

// Concrete implementation of Operators - provides all arithmetic operations
public class Calculator extends Operators {

    // Parses string to double, throws InvalidInputException if parsing fails
    public double parseExpression (String input) throws InvalidInputException{
        try {
            return Double.parseDouble(input);
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
            throw new DivisionByZeroException("Cannot divide by 0");
        return a / b;
    }

    // Throws DivisionByZeroException if divisor is 0
    @Override
    protected double modulo(double a, double b) {
        if (b == 0)
            throw new DivisionByZeroException("Cannot modulo by zero");
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

    //Overloaded methods for int paremeters
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
            throw new DivisionByZeroException("Cannot divide by 0");

        return (double) a / b;
    }

    // Parse and validate square root expression format, throws InvalidInputException if invalid
    public double squareRootExpression (String input) throws InvalidInputException {
        String[] expression = input.trim().split("\\s+");
        // Expected format: "sqr NUMBER"
        if (expression.length != 2)
            throw new InvalidInputException("Invalid expression format, please follow the said format");

        String operator = expression[0];
        double number = parseExpression(expression[1]); // Can throw InvalidInputException

        // Check if operator is valid
        if (operator.trim().equalsIgnoreCase("sqr") ||
                operator.trim().equalsIgnoreCase("sqrt") ||
                operator.trim().equalsIgnoreCase("√"))
            return squareRoot(number); // Can throw NegativeNumberException
        else
            throw new InvalidInputException("Invalid operator, try again");
    }

    // Parse and validate factorial expression format, throws InvalidInputException if invalid
    public double factorialExpression (String input) throws InvalidInputException {
        String[] expression = input.trim().split("\\s+");
        // Expected format: "NUMBER !"
        if (expression.length != 2)
            throw new InvalidInputException("Invalid expression format, please follow the said format");

        double number = parseExpression(expression[0]); // Can throw InvalidInputException
        String operator = expression[1];

        // Check if operator is valid
        if (operator.trim().equalsIgnoreCase("!"))
            return factorial(number); // Can throw NegativeNumberException or FactorialException
        else
            throw new InvalidInputException("Invalid operator, try again");
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