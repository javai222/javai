package com.plantilla.grasp_ut.service;

// Polymorphism
// Interface so different payment types can have different behavior
// Protected Variations
// Adding new payment type only needs a new class, no changes to existing code
public interface Payment {
    void process(double amount);
    String getPaymentType();
}