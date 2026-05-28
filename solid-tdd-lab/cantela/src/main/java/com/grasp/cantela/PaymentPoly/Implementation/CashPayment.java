package com.grasp.cantela.PaymentPoly.Implementation;

import com.grasp.cantela.PaymentPoly.Payment;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
// GRASP: Polymorphism - One of many Payment implementations
// GRASP: Low Coupling - Depends only on Payment interface
// GRASP: High Cohesion - Single responsibility: cash payment processing
// SOLID: LSP — Can replace any other Payment where only processPayment(double) is required.
// OOP: Composition-friendly — Spring injects this as a strategy bean, not via inheritance from other payment types.
public class CashPayment implements Payment {

    // GRASP: Information Expert - CashPayment knows how to process cash payments specifically
    @Override
    public String processPayment(double amount) {
        return "Processing cash payment of php" + amount;
    }

}
