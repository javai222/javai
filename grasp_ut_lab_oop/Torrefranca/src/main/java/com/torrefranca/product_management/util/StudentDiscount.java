package com.torrefranca.product_management.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism
// Another implementation of DiscountStrategy

@Component
public class StudentDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double price) {
        return price * 0.90;
    }
}