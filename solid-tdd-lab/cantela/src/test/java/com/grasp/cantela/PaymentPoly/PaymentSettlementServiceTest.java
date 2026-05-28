package com.grasp.cantela.PaymentPoly;

import com.grasp.cantela.Exception.NegativeAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// SOLID: DIP — Proves service is tested through mocked Payment abstraction, not a concrete channel.
@ExtendWith(MockitoExtension.class)
class PaymentSettlementServiceTest {

    @Mock
    private Payment payment;

    @InjectMocks
    private PaymentSettlementService paymentSettlementService;

    @Test
    void shouldDelegatesToPaymentStrategy() {
        when(payment.processPayment(99.5)).thenReturn("ok-99.5");

        String result = paymentSettlementService.settle(99.5);

        assertEquals("ok-99.5", result);
        verify(payment).processPayment(99.5);
    }

    @Test
    void shouldRejectsNonPositiveAmount() {
        assertThrows(NegativeAmountException.class, () -> paymentSettlementService.settle(0));
        assertThrows(NegativeAmountException.class, () -> paymentSettlementService.settle(-1));
        verifyNoInteractions(payment);
    }
}
