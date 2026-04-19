
package Demo;

import java.util.Scanner;

import Logic.BasicOp;
import Logic.UnaryOp;
import Exceptions.*;

public class CalculatorDemo_Saan_Javier_Mercado {
    public static void main(String[] args) {

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

        while (true) {
            
            System.out.print("-> ");
            String input = sc.nextLine().trim();

            //Exit condition
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program, sayonara!");
                break;
            }

            try {
                String[] parts = input.trim().split("\\s+");
                double result;

                //Binary operations
                if (parts.length == 3) {

                    double a = Double.parseDouble(parts[0]);
                    String operator = parts[1].toLowerCase();
                    double b = Double.parseDouble(parts[2]);

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


                //Unary operations
                else if (parts.length == 2) {

                    String operator = parts[0].toLowerCase();
                    double a = Double.parseDouble(parts[1]);
                    
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

                //Invalid format
                else {
                    throw new InvalidInputException("Invalid format. Use spaces between values");
                }


            //Exception handling
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

        sc.close();  
    }

}