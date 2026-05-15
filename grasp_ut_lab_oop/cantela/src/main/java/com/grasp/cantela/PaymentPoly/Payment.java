package com.grasp.cantela.PaymentPoly;

// GRASP: Polymorphism - Defines contract for different payment types
// GRASP: Protected Variations - Interface allows adding new payment methods without changing existing code
// GRASP: High Cohesion - Single responsibility: process payment behavior
public interface Payment {
    String processPayment(double amount);
}
