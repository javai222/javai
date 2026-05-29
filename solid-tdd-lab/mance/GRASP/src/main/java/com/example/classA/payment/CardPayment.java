package com.example.classA.payment;

public class CardPayment implements PaymentMethod {
    @Override
    public void pay() {
        System.out.println("Paid using Credit/Debit Card");
    }
}