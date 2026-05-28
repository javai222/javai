package com.grasp.cantela.PaymentPoly.Implementation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// GRASP: Polymorphism - Testing different Payment implementations
// GRASP: Protected Variations - Tests verify interface contract is honored by all implementations
class PaymentImplementationsTest {

    @Test
    void processPayment() {
        //Arrange
        CashPayment cashPayment = new CashPayment();
        BankTransferPayment bankTransferPayment = new BankTransferPayment();

        //Act and Assert
        // Test cash payment
       String outputCash = cashPayment.processPayment(100.0);
       assertEquals("Processing cash payment of php100.0", outputCash);
        // Expected output: "Processing cash payment of php100.0"

        // Test bank transfer payment
       String outputBank = bankTransferPayment.processPayment(200.0);
         assertEquals("Processing bank transfer payment of php200.0", outputBank);
        // Expected output: "Processing bank transfer payment of php200.0"
    }


}