package com.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - concrete implementation of Payment
@Component
public class CashPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing CASH payment of " + amount);
    }

    @Override
    public String getMethodName() {
        return "CASH";
    }
}
