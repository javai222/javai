package com.app.src.service;

import com.app.src.entity.ClothingItem;

public interface ClothingDiscountPolicy {
    double apply(ClothingItem item);
    String getDescription();
}