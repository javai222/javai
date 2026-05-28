package com.grasp.cantela.PaymentPoly;

import com.grasp.cantela.Exception.NegativeAmountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * SOLID: DIP — Depends on Payment abstraction; callers/tests supply concrete or mock implementations.
 * SOLID: OCP — New payment types extend behavior without editing this class (polymorphism on Payment).
 * SOLID: SRP — Single responsibility: validate amount bounds and delegate processing to Payment.
 * This class ensures the amount is positive and delegates to a payment impl using processPayment() method
 */
@Service
@RequiredArgsConstructor
public class PaymentSettlementService {

    private final Payment payment;


     // DRY: Centralized guard for non-positive amounts used by settlement flow.

    public String settle(double amount) {
        if (amount <= 0)
            throw new NegativeAmountException("Amount must be positive");

        return payment.processPayment(amount);
    }
}
