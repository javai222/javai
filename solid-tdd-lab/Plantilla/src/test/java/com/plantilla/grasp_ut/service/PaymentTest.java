package com.plantilla.grasp_ut.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

// SOLID: LSP - All payment types can replace Payment interface
@DisplayName("Payment Tests")
class PaymentTest {

    // Test 5 - LSP + OCP
    @Test
    @DisplayName("All payments work through Payment interface")
    void allPaymentsShouldWorkViaInterface() {
        Payment cash = new CashPayment();
        Payment card = new CreditCardPayment();
        Payment gcash = new GCashPayment();

        assertThatNoException().isThrownBy(() -> cash.process(100.0));
        assertThatNoException().isThrownBy(() -> card.process(100.0));
        assertThatNoException().isThrownBy(() -> gcash.process(100.0));
    }

    // Test 6 - LSP
    @Test
    @DisplayName("Each payment returns correct type")
    void eachPaymentReturnsCorrectType() {
        assertThat(new CashPayment().getPaymentType()).isEqualTo("CASH");
        assertThat(new CreditCardPayment().getPaymentType()).isEqualTo("CREDIT_CARD");
        assertThat(new GCashPayment().getPaymentType()).isEqualTo("GCASH");
    }
}