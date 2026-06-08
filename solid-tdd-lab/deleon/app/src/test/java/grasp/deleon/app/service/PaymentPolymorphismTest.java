package grasp.deleon.app.service;

import grasp.deleon.app.entity.CardPayment;
import grasp.deleon.app.entity.CashPayment;
import grasp.deleon.app.entity.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// GRASP: Polymorphism tested — both Payment implementations behave correctly
// through the same interface
class PaymentPolymorphismTest {

    // TEST 1 — CashPayment returns correct method name
    @Test
    void cashPaymentShouldReturnMethodName() {
        Payment payment = new CashPayment();
        assertEquals("CASH", payment.getMethodName());
    }

    // TEST 2 — CardPayment returns correct method name
    @Test
    void cardPaymentShouldReturnMethodName() {
        Payment payment = new CardPayment("5678");
        assertEquals("CARD", payment.getMethodName());
    }

    // TEST 3 — Both implementations share the same interface type
    @Test
    void bothPaymentsShouldImplementSameInterface() {
        Payment cash = new CashPayment();
        Payment card = new CardPayment("0000");

        assertInstanceOf(Payment.class, cash);
        assertInstanceOf(Payment.class, card);
    }

    // TEST 4 — CashPayment process() does not throw
    @Test
    void cashPaymentProcessShouldNotThrow() {
        Payment payment = new CashPayment();
        assertDoesNotThrow(() -> payment.process(250.0));
    }

    // TEST 5 — CardPayment process() does not throw
    @Test
    void cardPaymentProcessShouldNotThrow() {
        Payment payment = new CardPayment("9999");
        assertDoesNotThrow(() -> payment.process(350.0));
    }
}
