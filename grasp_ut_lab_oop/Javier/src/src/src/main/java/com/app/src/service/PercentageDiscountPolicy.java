package com.app.src.service;

import com.app.src.entity.ClothingItem;

public class PercentageDiscountPolicy implements ClothingDiscountPolicy {
    private final double percentage;

    public PercentageDiscountPolicy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(ClothingItem item) {
        return item.getPrice() - (item.getPrice() * percentage / 100);
    }

    @Override
    public String getDescription() {
        return percentage + "% off on all items";
    }
}