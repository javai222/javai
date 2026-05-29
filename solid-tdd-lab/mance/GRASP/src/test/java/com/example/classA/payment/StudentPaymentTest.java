package com.example.classA.payment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class StudentPaymentTest {

    @Test
    void shouldSupportMultiplePaymentMethods() {
        PaymentMethod gcash = new GcashPayment();
        PaymentMethod card = new CardPayment();

        assertNotNull(gcash);
        assertNotNull(card);

        gcash.pay();
        card.pay();
    }
}