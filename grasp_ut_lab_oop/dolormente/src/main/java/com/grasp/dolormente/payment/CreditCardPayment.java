package com.grasp.dolormente.payment;

public class CreditCardPayment
        implements PaymentMethod {

    @Override
    public String processPayment(double amount) {

        return "Credit card payment processed: "
                + amount;
    }
}