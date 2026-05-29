package com.casapao.orders.app.service;

// GRASP: Protected Variations
public interface PaymentService {

    String processPayment(double amount);
}