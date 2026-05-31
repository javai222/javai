package com.plantilla.grasp_ut.service;

import org.springframework.stereotype.Component;

// Polymorphism - third implementation of Payment interface
// Protected Variations - new payment added without touching existing code
// High Cohesion - only handles GCash payment logic
@Component("gcashPayment")
public class GCashPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("[GCashPayment] GCash payment of PHP " + amount + " sent.");
    }

    @Override
    public String getPaymentType() {
        return "GCASH";
    }
}