package com.app.src.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClothingPriceTest {

    @Test
    void shouldCreatePriceWithCorrectAmount() {
        ClothingPrice price = new ClothingPrice(350.00);
        assertEquals(350.00, price.getAmount());
        assertEquals("PHP", price.getCurrency());
    }

    @Test
    void shouldReturnNewObjectWhenDiscountApplied() {
        ClothingPrice original = new ClothingPrice(350.00);
        ClothingPrice discounted = original.withDiscount(10);

        // Immutability proof: original is unchanged after discount applied
        assertEquals(350.00, original.getAmount());
        assertEquals(315.00, discounted.getAmount(), 0.01);
    }

    @Test
    void shouldThrowExceptionForNegativePrice() {
        // Edge case: negative price must be rejected
        assertThrows(IllegalArgumentException.class, () -> new ClothingPrice(-10));
    }

    @Test
    void shouldFormatPriceCorrectly() {
        ClothingPrice price = new ClothingPrice(1200.00);
        assertEquals("₱1,200.00", price.getFormatted());
    }

    @Test
    void shouldAllowZeroPrice() {
        // Edge case: free items are valid
        ClothingPrice price = new ClothingPrice(0);
        assertEquals(0.0, price.getAmount());
    }
}