/* 
* Created by Dolormente, Henry II, S.
* 
*
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
    return a + b;
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

  }

}
