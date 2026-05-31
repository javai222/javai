package com.app.src.service;

import com.app.src.entity.ClothingItem;

// SOLID: OCP - open for extension (new policies), closed for modification
// SOLID: ISP - lean interface, only methods that every implementation actually needs
public interface ClothingDiscountPolicy {
    double apply(ClothingItem item);
    String getDescription();
}