package com.grasp.cantela.PaymentPoly.Implementation;

import com.grasp.cantela.PaymentPoly.Payment;
import org.springframework.stereotype.Component;

@Component
// GRASP: Polymorphism - One of many Payment implementations
// GRASP: Low Coupling - Depends only on Payment interface
// GRASP: High Cohesion - Single responsibility: bank transfer payment processing
// SOLID: LSP — Substitutable for Payment without breaking PaymentSettlementService.
public class BankTransferPayment implements Payment {

    // GRASP: Information Expert - BankTransferPayment knows how to process bank transfer payments specifically
    @Override
    public String processPayment(double amount) {
        return "Processing bank transfer payment of php" + amount;
    }


}
