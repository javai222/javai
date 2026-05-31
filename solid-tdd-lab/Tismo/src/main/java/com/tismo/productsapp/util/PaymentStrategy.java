package com.tismo.productsapp.util;

// GRASP: Protected Variations - Interface protects system from changes in payment implementations
public interface PaymentStrategy   {
    double process(double amount);
}
