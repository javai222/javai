package grasp.deleon.app.service;

import grasp.deleon.app.entity.CardPayment;
import grasp.deleon.app.entity.CashPayment;
import grasp.deleon.app.entity.GCashPayment;
import grasp.deleon.app.entity.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

// Tests proving SOLID: LSP and OCP are implemented correctly.
// LSP: Every Payment implementation must be safely substitutable for Payment.
// OCP: GCashPayment was added without changing any existing code.
class PolymorphismTest {

    // Provides all payment implementations as a stream for parameterized tests.
    // This proves OCP — when you add a new payment type, you only add it here.
    static Stream<Payment> paymentImplementations() {
        return Stream.of(
                new CashPayment(),
                new CardPayment("5678"),
                new GCashPayment("09171234567")
        );
    }

    // TEST 1 — LSP: All implementations process() without throwing
    @ParameterizedTest
    @MethodSource("paymentImplementations")
    void allImplementationsShouldProcessWithoutThrowing(Payment payment) {
        // SOLID: LSP - Every implementation must fulfil the Payment contract
        assertDoesNotThrow(() -> payment.process(500.0),
                payment.getMethodName() + " violated LSP by throwing on process()");
    }

    // TEST 2 — LSP: All implementations return a non-null, non-blank method name
    @ParameterizedTest
    @MethodSource("paymentImplementations")
    void allImplementationsShouldReturnNonBlankMethodName(Payment payment) {
        String name = payment.getMethodName();
        assertNotNull(name, "getMethodName() must not return null");
        assertFalse(name.isBlank(), "getMethodName() must not return a blank string");
    }

    // TEST 3 — OCP: CashPayment method name is exactly "CASH"
    @Test
    void cashPaymentShouldReturnCorrectMethodName() {
        Payment payment = new CashPayment();
        assertEquals("CASH", payment.getMethodName());
    }

    // TEST 4 — OCP: CardPayment method name is exactly "CARD"
    @Test
    void cardPaymentShouldReturnCorrectMethodName() {
        Payment payment = new CardPayment("0000");
        assertEquals("CARD", payment.getMethodName());
    }

    // TEST 5 — OCP: GCashPayment added as extension — method name is "GCASH"
    @Test
    void gcashPaymentShouldReturnCorrectMethodName() {
        // OCP proof: GCashPayment is a pure extension.
        // No existing class was modified to make this work.
        Payment payment = new GCashPayment("09991234567");
        assertEquals("GCASH", payment.getMethodName());
    }

    // TEST 6 — All three are instanceof Payment (interface contract fulfilled)
    @Test
    void allPaymentsShouldBeInstanceOfPaymentInterface() {
        assertInstanceOf(Payment.class, new CashPayment());
        assertInstanceOf(Payment.class, new CardPayment("1111"));
        assertInstanceOf(Payment.class, new GCashPayment("09170000000"));
    }
}
