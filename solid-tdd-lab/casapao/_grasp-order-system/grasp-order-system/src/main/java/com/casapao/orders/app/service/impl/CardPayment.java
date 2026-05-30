package com.casapao.orders.app.service.impl;

import com.casapao.orders.app.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class CardPayment implements PaymentService {

    @Override
    public String processPayment(double amount) {
        return "Card payment processed: " + amount;
    }
}