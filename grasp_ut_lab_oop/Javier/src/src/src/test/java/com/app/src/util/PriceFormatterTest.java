package com.app.src.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// GRASP: Pure Fabrication - tests the utility class in complete isolation (no Spring context needed)
class PriceFormatterTest {

    // ─── Test 1: Format a standard price ─────────────────────────
    @Test
    void testFormat_StandardPrice_ReturnsFormattedString() {
        String result = PriceFormatter.format(1200.0);
        assertEquals("₱1,200.00", result);
    }

    // ─── Test 2: Format a small price ────────────────────────────
    @Test
    void testFormat_SmallPrice_ReturnsFormattedString() {
        String result = PriceFormatter.format(350.0);
        assertEquals("₱350.00", result);
    }

    // ─── Test 3: Format a zero price ─────────────────────────────
    @Test
    void testFormat_ZeroPrice_ReturnsZeroString() {
        String result = PriceFormatter.format(0.0);
        assertEquals("₱0.00", result);
    }

    // ─── Test 4: Format with a 10% discount ──────────────────────
    @Test
    void testFormatWithDiscount_TenPercent_ReturnsDiscountedPrice() {
        String result = PriceFormatter.formatWithDiscount(1000.0, 10.0);
        assertEquals("₱900.00", result);
    }

    // ─── Test 5: Format with a 50% discount ──────────────────────
    @Test
    void testFormatWithDiscount_FiftyPercent_ReturnsHalfPrice() {
        String result = PriceFormatter.formatWithDiscount(800.0, 50.0);
        assertEquals("₱400.00", result);
    }

    // ─── Test 6: Format with 0% discount (no change) ─────────────
    @Test
    void testFormatWithDiscount_ZeroPercent_ReturnsOriginalPrice() {
        String result = PriceFormatter.formatWithDiscount(350.0, 0.0);
        assertEquals("₱350.00", result);
    }

    // ─── Test 7: Price is within budget ──────────────────────────
    @Test
    void testIsWithinBudget_PriceBelowBudget_ReturnsTrue() {
        assertTrue(PriceFormatter.isWithinBudget(350.0, 500.0));
    }

    // ─── Test 8: Price exceeds budget ────────────────────────────
    @Test
    void testIsWithinBudget_PriceAboveBudget_ReturnsFalse() {
        assertFalse(PriceFormatter.isWithinBudget(1200.0, 500.0));
    }

    // ─── Test 9: Price exactly equals budget ─────────────────────
    @Test
    void testIsWithinBudget_PriceEqualsBudget_ReturnsTrue() {
        assertTrue(PriceFormatter.isWithinBudget(500.0, 500.0));
    }

    // ─── Test 10: Parse a formatted price string back to double ──
    @Test
    void testParse_FormattedString_ReturnsDouble() {
        double result = PriceFormatter.parse("₱1,200.00");
        assertEquals(1200.0, result, 0.001);
    }
}