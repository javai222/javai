package com.calculator.javier.main;

import com.calculator.javier.service.CalculatorService;
import com.calculator.javier.exception.DivisionByZeroException;

public class CalculatorDemo_Javier {

    public static void main(String[] args) {

        CalculatorService calc = new CalculatorService();

        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Subtract: " + calc.subtract(10, 4));
        System.out.println("Multiply: " + calc.multiply(6, 2));

        try {
            System.out.println("Divide: " + calc.divide(10, 0)); // triggers exception
        } catch (DivisionByZeroException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}