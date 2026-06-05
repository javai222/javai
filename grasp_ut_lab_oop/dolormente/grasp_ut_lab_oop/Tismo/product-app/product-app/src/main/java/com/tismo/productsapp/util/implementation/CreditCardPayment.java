package com.tismo.productsapp.util.implementation;

import com.tismo.productsapp.util.PaymentStrategy;

// GRASP: Polymorphism - CreditCardPayment provides alternative payment behavior
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public double process(double amount) {
        return amount * 1.02; // 2% fee
    }
}