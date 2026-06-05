package com.plantilla.grasp_ut.service;

import org.springframework.stereotype.Component;

// Polymorphism - one implementation of Payment interface
// High Cohesion - only handles cash payment logic
@Component("cashPayment")
public class CashPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("[CashPayment] Cash payment of PHP " + amount + " received.");
    }

    @Override
    public String getPaymentType() {
        return "CASH";
    }
}