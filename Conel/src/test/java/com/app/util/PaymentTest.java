package com.app.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism - testing different implementations behave correctly
class PaymentTest {

    @Test
    void cashPaymentShouldReturnCorrectMethodName() {
        Payment payment = new CashPayment();
        assertEquals("CASH", payment.getMethodName());
    }

    @Test
    void cardPaymentShouldReturnCorrectMethodName() {
        Payment payment = new CardPayment();
        assertEquals("CARD", payment.getMethodName());
    }

    @Test
    void cashPaymentShouldProcessWithoutException() {
        Payment payment = new CashPayment();
        assertDoesNotThrow(() -> payment.process(500.0));
    }

    @Test
    void cardPaymentShouldProcessWithoutException() {
        Payment payment = new CardPayment();
        assertDoesNotThrow(() -> payment.process(1500.0));
    }
}
