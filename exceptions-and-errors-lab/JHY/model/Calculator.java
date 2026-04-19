/* 
* Created by Casapao, Jasmin Ann M. | Dolormente, Henry II S. | Tismo, Yvette Germaine E.
* Calculator class 
* Throws custom exceptions for invalid input, division by zero, negative numbers
*/

package models;

import exceptions.DivisByZeroException;
import exceptions.InvalInputException;
import exceptions.NegatNumberException;

// Calculator class inherits abstract methods from OperatorAbs
public class Calculator extends OperatorAbs {

  // For Addition
  @Override
  protected int add(int a, int b) {
    return a + b;
  }

  @Override
  protected double add(double a, double b) {
    return a + b;
  }
  // For Subtraction
  @Override
  protected int subtract(int a, int b) {
    return a - b;
  }

  @Override
  protected double subtract(double a, double b) {
    return a - b;
  }  
  // For Multiplication
  @Override
  protected int multiply(int a, int b) {
    return a * b;
  }

  @Override
  protected double multiply(double a, double b) {
    return a * b;
  }  
  // For divison by Zero
  @Override
  protected double divide(double a, double b) throws DivisionByZeroException {
    if (b == 0)
        throw new DivisionByZeroException("Division by 0 is not possible.");
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
