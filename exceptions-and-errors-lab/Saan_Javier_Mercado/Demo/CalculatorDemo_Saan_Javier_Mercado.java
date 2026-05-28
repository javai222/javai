/*   Author: Saan, Kenneth | Justin Javier | Dustin Elijah Mercado
    
- What exceptions did you create?
We created 5 exceptions which are DivisionbyZero, FactorialExceptions, LogarithmException,
NegativeNumberException and undifinedTangentException

- Which are checked vs unchecked?

in java there is this two type of error which are checked, java forces you to take care of the error in compile and the unchecked error that does not appear on compile time bat appears on runtime
for example the unchecked error is the division by zero, it does not appear on compile time but when you run the 
program and you try to divide by zero it will throw an error, while the checked error is the factorial exception, 
it will appear on compile time because you have to handle it in your code and the checked error is the logarithm exception, it will appear on compile time because you have to handle it in your code

- Where are exceptions thrown?
The exceptions are thrown in the logic classes, for example the division by zero exception is thrown in the BasicOp class when you try to divide by zero, while the factorial exception is thrown in the UnaryOp class when you try to take the factorial of a negative number or a non-integer, and the logarithm exception is thrown in the UnaryOp class when you try to take the logarithm of a non-positive number.

- Where are they handled?
The exceptions are handled in the main method of the CalculatorDemo_Saan_Javier_Mercado class, where we use try-catch blocks to catch the specific exceptions and print the error messages to the user.

- Where does propagation occur?
Propagation occurs when an exception is thrown and not caught in the method where it occurred, it propagates up the call stack until it is caught by a try-catch block or it reaches the main method and causes the program to terminate. For example, if you try to take the factorial of a negative number in the UnaryOp class, it will throw a FactorialExceptions which will propagate up to the main method where it will be caught and handled.

- How did you apply OOP concepts?
We applied OOP concepts by creating classes for the basic operations (BasicOp) and unary operations (UnaryOp), and we used inheritance to create a hierarchy of operations. We also created custom exceptions to handle specific error cases, which is an example of encapsulation. The main method in the CalculatorDemo_Saan_Javier_Mercado class serves as the entry point for the program and demonstrates how to use the classes and handle exceptions, which is an example of abstraction.

*/

package Demo;

import java.util.Scanner;

import Logic.BasicOp;
import Logic.UnaryOp;
import Exceptions.InvalidInputException;
import Exception.Divisionbyzero;
import Exception.FactorialExceptions;
import Exception.LogarithmException;
import Exception.UndefinedTangentException;
import Exception.NegativeNumberException;

public class CalculatorDemo_Saan_Javier_Mercado {
    public static void main(String[] args) {

        // Initialize Scanner and operation classes
        Scanner sc = new Scanner(System.in);
        BasicOp basic = new BasicOp();
        UnaryOp unary = new UnaryOp();

        System.out.println("""
                ===== Calculator =====
                Input format:
                [number] [operator] [number]
                
                Available Operators: +, -, *, /, %, ^
                Unary Operators: sqrt, fact, log, sin, cos, tan

                Enter 'exit' to terminate the program.
                """);

        // Main calculator loop - continues until user exits
        while (true) {
            
            System.out.print("-> ");
            String input = sc.nextLine().trim();

            // Check if user wants to exit
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program, sayonara!");
                break;
            }

            try {
                // Parse input into parts (number, operator, number or operator, number)
                String[] parts = input.trim().split("\\s+");
                double result;

                // Handle binary operations (two operands with one operator)
                if (parts.length == 3) {

                    // Extract operands and operator
                    double a = Double.parseDouble(parts[0]);
                    String operator = parts[1].toLowerCase();
                    double b = Double.parseDouble(parts[2]);

                    // Perform the appropriate binary operation
                    switch (operator) {
                        case "+" -> result = basic.add(a, b);
                        case "-" -> result = basic.subtract(a, b);
                        case "*" -> result = basic.multiply(a, b);
                        case "/" -> result = basic.division(a, b);
                        case "%" -> result = basic.modulo(a, b);
                        case "^" -> result = basic.power(a, b);
                        default -> throw new InvalidInputException("Invalid binary operator");
                    }

                    System.out.printf("Result: %.4f%n", result);
                }  

                // Handle unary operations (one operand with operator)
                else if (parts.length == 2) {

                    // Extract operator and operand
                    String operator = parts[0].toLowerCase();
                    double a = Double.parseDouble(parts[1]);
                    
                    // Perform the appropriate unary operation
                    switch (operator) {
                        case "sqrt" -> result = unary.squareRoot(a);
                        case "fact" -> result = unary.factorial(a);
                        case "log" -> result = unary.logarithm(a);
                        case "sin" -> result = unary.sine(a);
                        case "cos" -> result = unary.cosine(a);
                        case "tan" -> result = unary.tangent(a);
                        default -> throw new InvalidInputException("Invalid unary operator");
                    }

                    System.out.printf("Result: %.4f%n", result);
                }

                // Handle invalid input format
                else {
                    throw new InvalidInputException("Invalid format. Use spaces between values");
                }

            // Catch and handle specific exceptions
            } catch (Divisionbyzero e) {
                System.out.println("Error: " + e.getMessage());

            } catch (FactorialExceptions e) {
                System.out.println("Error: " + e.getMessage());

            } catch (LogarithmException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (UndefinedTangentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (NegativeNumberException e) {
                System.out.println("Error: " + e.getMessage());
            
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter valid numbers");

            } catch (InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());

            } finally {
                System.out.println("\nOperation completed.\n");
            }
         }

        // Close the Scanner resource
        sc.close();  
    }

}