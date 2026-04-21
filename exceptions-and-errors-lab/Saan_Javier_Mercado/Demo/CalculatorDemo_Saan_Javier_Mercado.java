
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