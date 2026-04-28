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

/*
PACKAGE ORGANIZATION:
I organized my project into separate packages such as service, exception, and main
to clearly separate responsibilities of each class.

REASON FOR SEPARATION:
The service package handles the calculator logic, while the exception package
contains custom errors. This improves readability and maintainability.

ENCAPSULATION:
Packages improve encapsulation by grouping related classes and limiting access
using access modifiers like private and package-private.

EXCEPTIONS LOCATION:
All custom exceptions are placed in the exception package for better organization
and reusability.

BUILD TOOL:
I chose Maven because it is simple to use and standard in Java projects. It helps
manage dependencies and build the project efficiently.
*/