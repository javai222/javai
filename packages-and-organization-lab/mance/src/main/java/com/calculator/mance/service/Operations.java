package com.calculator.mance.service;

// Interface defining calculator operations
public interface Operations {

    int add(int a, int b);
    double add(double a, double b);

    int subtract(int a, int b);
    double subtract(double a, double b);

    int multiply(int a, int b);
    double multiply(double a, double b);

    // FIX: keep consistency (NO throws, since your runtime exceptions handle errors)
    int divide(int a, int b);
    double divide(double a, double b);
}
