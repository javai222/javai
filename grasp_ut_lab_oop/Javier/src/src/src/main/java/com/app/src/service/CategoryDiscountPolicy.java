package com.app.src.service;

import com.app.src.entity.ClothingItem;

public class CategoryDiscountPolicy implements ClothingDiscountPolicy {
    private final String targetCategory;
    private final double percentage;

    public CategoryDiscountPolicy(String targetCategory, double percentage) {
        this.targetCategory = targetCategory;
        this.percentage = percentage;
    }

    @Override
    public double apply(ClothingItem item) {
        if (item.getCategory().equalsIgnoreCase(targetCategory)) {
            return item.getPrice() - (item.getPrice() * percentage / 100);
        }
        return item.getPrice();
    }

    @Override
    public String getDescription() { return percentage + "% off on " + targetCategory; }
}