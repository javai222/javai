package com.tismo.productsapp.util.implementation;

import com.tismo.productsapp.util.PaymentStrategy;

// GRASP: Polymorphism - CashPayment provides specific payment behavior
public class CashPayment implements PaymentStrategy {

    @Override
    public double process(double amount) {
        return amount; // no fee
    }
}