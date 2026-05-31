package com.casapao.orders.app.service;

import com.casapao.orders.app.service.impl.CardPayment;
import com.casapao.orders.app.service.impl.GCashPayment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void shouldSupportCardPaymentPolymorphism() {
        PaymentService payment = new CardPayment();

        String result = payment.processPayment(100);

        assertNotNull(result);
        assertTrue(result.contains("Card"));
    }

    @Test
    void shouldSupportGCashPaymentPolymorphism() {
        PaymentService payment = new GCashPayment();

        String result = payment.processPayment(100);

        assertNotNull(result);
        assertTrue(result.contains("GCash"));
    }
}