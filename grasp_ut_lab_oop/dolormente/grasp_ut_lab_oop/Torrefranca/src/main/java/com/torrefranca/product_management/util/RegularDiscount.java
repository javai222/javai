package com.torrefranca.product_management.util;

import org.springframework.stereotype.Component;

// GRASP: Polymorphism
// One implementation of DiscountStrategy

@Component
public class RegularDiscount implements DiscountStrategy {

    @Override
    public double applyDiscount(double price) {
        return price;
    }
}