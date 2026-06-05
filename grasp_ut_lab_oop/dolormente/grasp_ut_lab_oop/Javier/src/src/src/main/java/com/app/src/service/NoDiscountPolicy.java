package com.app.src.service;

import com.app.src.entity.ClothingItem;

public class NoDiscountPolicy implements ClothingDiscountPolicy {
    @Override
    public double apply(ClothingItem item) { return item.getPrice(); }
    @Override
    public String getDescription() { return "No discount applied"; }
}