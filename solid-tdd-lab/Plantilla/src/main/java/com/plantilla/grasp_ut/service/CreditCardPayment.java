package com.plantilla.grasp_ut.service;

import org.springframework.stereotype.Component;

// Polymorphism - another implementation of Payment interface
// High Cohesion - only handles credit card payment logic
@Component("creditCardPayment")
public class CreditCardPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("[CreditCardPayment] Credit card charged PHP " + amount);
    }

    @Override
    public String getPaymentType() {
        return "CREDIT_CARD";
    }
}