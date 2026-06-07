package com.grasp.dolormente.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentMethodTest {

    @Test
    void shouldProcessCashPayment() {

        PaymentMethod payment =
                new CashPayment();

        String result =
                payment.processPayment(100);

        assertTrue(
                result.contains("Cash")
        );
    }

    @Test
    void shouldProcessCreditCardPayment() {

        PaymentMethod payment =
                new CreditCardPayment();

        String result =
                payment.processPayment(100);

        assertTrue(
                result.contains("Credit card")
        );
    }
}