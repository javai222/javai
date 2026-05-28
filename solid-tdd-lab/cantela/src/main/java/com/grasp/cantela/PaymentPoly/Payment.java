package com.grasp.cantela.PaymentPoly;

// GRASP: Polymorphism - Defines contract for different payment types
// GRASP: Protected Variations - Interface allows adding new payment methods without changing existing code
// GRASP: High Cohesion - Single responsibility: process payment behavior
// SOLID: OCP — Extend behavior by adding new Payment implementations instead of editing consumers.
// SOLID: LSP — Implementations must honor the contract so any Payment can be substituted safely.
// SOLID: ISP — Minimal surface: one operation, no fat “god interface”.
public interface Payment {
    String processPayment(double amount);
}
