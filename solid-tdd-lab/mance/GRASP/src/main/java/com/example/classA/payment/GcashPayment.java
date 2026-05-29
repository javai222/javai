package com.example.classA.payment;

public class GcashPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Paid using GCash");
    }
}