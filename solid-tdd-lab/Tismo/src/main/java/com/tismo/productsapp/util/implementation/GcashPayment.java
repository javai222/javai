package com.tismo.productsapp.util.implementation;

import com.tismo.productsapp.util.PaymentStrategy;

// SOLID: OCP - New payment methods can be added without modifying ProductService
public class GcashPayment implements PaymentStrategy {

    private static final double servicefee = 10;

    @Override
    public double process(double amount) {
        return amount + servicefee;
    }
}
