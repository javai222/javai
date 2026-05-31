package com.app.util;

// GRASP: Polymorphism + Protected Variations - interface allows future payment methods
public interface Payment {
    void process(double amount);
    String getMethodName();
}
