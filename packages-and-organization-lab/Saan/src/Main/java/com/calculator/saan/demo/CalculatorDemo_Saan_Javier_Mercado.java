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


- How did you organize your packages?
I organized my packages by separating their functionalities.
- Why did you separate your classes this way?
to be more organized and to follow the single responsibility principle, for example the BasicOp class is responsible for handling basic operations while the UnaryOp class is responsible for handling unary operations, and the exceptions are separated into their own package to keep the code clean and organized.
- How do packages improve encapsulation?
Packages improve encapsulation by grouping related classes and interfaces together, which helps to hide the internal implementation details from other parts of the program. This allows for better modularity and separation of concerns, making it easier to maintain and update the code without affecting other parts of the program. For example, the exceptions are grouped together in their own package, which allows us to manage and handle them separately from the main logic of the calculator.
- Where are your exceptions located?
The exceptions are located in the "com.calculator.saan.exception" package, which is separate from the main logic of the calculator. This allows us to manage and handle the exceptions separately from the main logic of the calculator, and it also helps to keep the code organized and clean.
- Why did you choose Maven or Gradle?
I chose maven because the program is not that complicated so I used because it is easier unlike gradle that is complicated but capable of handling huge projects.
*/

package com.calculator.saan.demo;

import java.util.Scanner;
import com.calculator.saan.services.basicServices;
import com.calculator.saan.services.UnaryServices;
import com.calculator.saan.contract.basicOp;
import com.calculator.saan.contract.unaryOp;
import com.calculator.saan.exception.InvalidInputException;
import com.calculator.saan.exception.negativeNumberException;
import com.calculator.saan.exception.divisionbyzero;
import com.calculator.saan.exception.factorialExceptions;
import com.calculator.saan.exception.logarithmException;
import com.calculator.saan.exception.undefinedTangentException;

public class CalculatorDemo_Saan_Javier_Mercado {
    public static void main(String[] args) {

        // Initialize Scanner and operation classes
        Scanner sc = new Scanner(System.in);
        basicOp basic = new basicServices();
        unaryOp unary = new UnaryServices();

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
            } catch (divisionbyzero e) {
                System.out.println("Error: " + e.getMessage());

            } catch (factorialException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (logarithmException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (undefinedTangentException e) {
                System.out.println("Error: " + e.getMessage());

            } catch (negativeNumberException e) {
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