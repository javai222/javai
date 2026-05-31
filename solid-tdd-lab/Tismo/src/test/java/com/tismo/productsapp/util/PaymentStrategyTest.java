package com.tismo.productsapp.util;

import com.tismo.productsapp.util.implementation.CashPayment;
import com.tismo.productsapp.util.implementation.CreditCardPayment;
import com.tismo.productsapp.util.implementation.GcashPayment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentStrategyTest {

    @Test
    void testCashPayment() {
        PaymentStrategy strategy = new CashPayment();
        assertEquals(100, strategy.process(100));
    }

    @Test
    void testCreditCardPayment() {
        PaymentStrategy strategy = new CreditCardPayment();
        assertEquals(102, strategy.process(100));
    }

    @Test
    void testGcashPayment() {
        PaymentStrategy strategy = new GcashPayment();

        double result = strategy.process(100);
        assertEquals(110, result);
    }
}