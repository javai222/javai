package com.app.src.service;

import com.app.src.entity.ClothingItem;

public class SeasonalSalePolicy implements ClothingDiscountPolicy {
    private final double percentage;
    private final String seasonName;

    public SeasonalSalePolicy(String seasonName, double percentage) {
        this.seasonName = seasonName;
        this.percentage = percentage;
    }

    @Override
    public double apply(ClothingItem item) {
        return item.getPrice() - (item.getPrice() * percentage / 100);
    }

    @Override
    public String getDescription() {
        return seasonName + " sale: " + percentage + "% off";
    }
}