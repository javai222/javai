package com.torrefranca.product_management.util;

// GRASP: Protected Variations
// Interface protects the system from changes in discount implementations

public interface DiscountStrategy {

    double applyDiscount(double price);
}