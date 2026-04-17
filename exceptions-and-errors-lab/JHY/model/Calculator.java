/* 
* Created by Casapao, Jasmin Ann M. | Dolormente, Henry II S. | Tismo, Yvette Germaine E.
* Calculator class -
* Throws custom exceptions for invalid input, division by zero, negative numbers
*/

package models;

import exceptions.DivisionByZeroException;
import exceptions.InvalidInputException;
import exceptions.NegativeNumberException;

// Calculator class inherits abstract methods from OperatorAbs
public class Calculator extends OperatorAbs {

  // For Addition
  @Override
  public int add(int a, int b) {
    return a + b;
  }

  @Override
  public double add(double a, double b) {
    return a + b;
  }
  // For Subtraction
  @Override
  public int subtract(int a, int b) {
    return a - b;
  }

  @Override
  public double subtract(double a, double b) {
    return a - b;
  }  
  // For Multiplication
  @Override
  public int multiply(int a, int b) {
    return a * b;
  }

  @Override
  public double multiply(double a, double b) {
    return a * b;
  }  
  // For divison by Zero
  @Override
  public double division(int a, int b) throws DivisionByZeroException {
    if (b == 0)
        throw new InvalidException("Division by 0 is not possible.");
    return (double) a / b;
  }
  // Checking if the value is a negative number
  public void checkNegative(double value) {
    if (value < 0) 
        throw new NegativeNumberException("Negative values are not allowed.");
  }
  // Converts string input to double
  public double getValidNumber(String input) throws InvalidInputException {
    try {
        return Double.parseDouble(input);
    } catch (NumberFormatException inv) {
        throw new InvalidInputException("Invalid input! Only numbers are allowed.");
    }
  }

}
