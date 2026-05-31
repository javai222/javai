package com.app.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism - second implementation of Payment
@Component
public class CardPayment implements Payment {

    @Override
    public void process(double amount) {
        System.out.println("Processing CARD payment of " + amount);
    }

    @Override
    public String getMethodName() {
        return "CARD";
    }
}
