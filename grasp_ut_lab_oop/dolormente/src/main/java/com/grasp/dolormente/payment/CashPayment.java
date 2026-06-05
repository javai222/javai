package com.grasp.dolormente.payment;

public class CashPayment
        implements PaymentMethod {

    @Override
    public String processPayment(double amount) {

        return "Cash payment processed: "
                + amount;
    }
}