package com.casapao.orders.app.service.impl;

import com.casapao.orders.app.service.PaymentService;
import org.springframework.stereotype.Service;

// SOLID: OCP - new payment type without modifying existing code
@Service
public class GCashPayment implements PaymentService {

    @Override
    public String processPayment(double amount) {
        return "GCash payment processed: " + amount;
    }
}
