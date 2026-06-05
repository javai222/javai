package com.grasp.dolormente.payment;

// GRASP: Protected Variations
// GRASP: Polymorphism
public interface PaymentMethod {

    String processPayment(double amount);

}