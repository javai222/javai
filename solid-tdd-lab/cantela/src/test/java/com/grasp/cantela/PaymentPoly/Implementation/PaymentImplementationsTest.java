package com.grasp.cantela.PaymentPoly.Implementation;

import com.grasp.cantela.PaymentPoly.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// GRASP: Polymorphism - Testing different Payment implementations
// GRASP: Protected Variations - Tests verify interface contract is honored by all implementations
// SOLID: LSP — Every implementation must satisfy the same observable contract for a given amount.
class PaymentImplementationsTest {

    static Stream<Arguments> paymentChannels() {
        return Stream.of(
                arguments(new CashPayment(), 100.0, "cash", "php100.0"),
                arguments(new BankTransferPayment(), 200.0, "bank transfer", "php200.0")
        );
    }

    @ParameterizedTest
    @MethodSource("paymentChannels")
    void shouldProduceExpectedMessage(Payment payment, double amount, String channelToken, String amountToken) {
        //Arrange
        String output = payment.processPayment(amount);

        //Assert
        assertTrue(output.toLowerCase().contains(channelToken), output);
        assertTrue(output.contains(amountToken), output);
    }

    @Test
    void shouldListPaymentsWithoutChangingLogic() {
        //Arrange
        List<Payment> payments = List.of(new CashPayment(), new BankTransferPayment());

        //Act and Asssert
        for (Payment payment : payments) {
            assertNotNull(payment.processPayment(1.0));
            assertFalse(payment.processPayment(1.0).isBlank());
        }
    }
}
