/* 
* Created by Casapao, Jasmin Ann M. | Dolormente, Henry II S. | Tismo, Yvette Germaine E.
* Calculator class -
* Throws custom exceptions for invalid input, division by zero, negative numbers
*/

package models;

public class Calculator {

  public int add(int a, int b) {
    return a + b;
  }

  public double add(double a, double b) {
    return a + b;
  }

  public int subtract(int a, int b) {
    return a - b;
  }

  public double subtract(double a, double b) {
    return a - b;
  }  
  
  public int multiply(int a, int b) {
    return a * b;
  }

  public double multiply(double a, double b) {
    return a * b;
  }  
  
  public double division(int a, int b) throwsInvalidException {
    if (b == 0)
        throw new InvalidException("Error: Division by 0 is not possible.");
    return (double) a / b;
  }

  public void checkNegative(double value) {
    if (value < 0) 
        throw new NegativeNumberException("Error: Negative values are not allowed.");
  }

  public double getValidNumber(String input) throws InvalidInputException {
    try {
        return Double.parseDouble(input);
    } catch (NumberFormatException inv) {
        throw new InvalidInputException("Invalid input! Only numbers are allowed.");
    }
  }

}
