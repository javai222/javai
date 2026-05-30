package com.app.src.service;

import com.app.src.entity.ClothingItem;
import org.springframework.stereotype.Service;
// SOLID: SRP - handles only discount policy management and application
// SOLID: DIP - depends on ClothingDiscountPolicy abstraction, not a concrete implementation
@Service
public class ClothingDiscountService {

    // DIP: abstraction injected by Spring, not instantiated here
    private ClothingDiscountPolicy discountPolicy;

    public ClothingDiscountService(ClothingDiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public void setDiscountPolicy(ClothingDiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double getDiscountedPrice(ClothingItem item) {
        return discountPolicy.apply(item);
    }

    public String getDiscountDescription() {
        return discountPolicy.getDescription();
    }
}