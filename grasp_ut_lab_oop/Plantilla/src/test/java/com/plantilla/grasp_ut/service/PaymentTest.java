package com.plantilla.grasp_ut.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Payment Polymorphism Tests")
class PaymentTest {

    // Test 1
    @Test
    @DisplayName("CashPayment should process without error")
    void cashPaymentShouldProcess() {
        Payment payment = new CashPayment();
        assertThatNoException().isThrownBy(() -> payment.process(1500.0));
    }

    // Test 2
    @Test
    @DisplayName("CreditCardPayment should process without error")
    void creditCardPaymentShouldProcess() {
        Payment payment = new CreditCardPayment();
        assertThatNoException().isThrownBy(() -> payment.process(25000.0));
    }

    // Test 3
    @Test
    @DisplayName("GCashPayment should process without error")
    void gcashPaymentShouldProcess() {
        Payment payment = new GCashPayment();
        assertThatNoException().isThrownBy(() -> payment.process(999.0));
    }
}