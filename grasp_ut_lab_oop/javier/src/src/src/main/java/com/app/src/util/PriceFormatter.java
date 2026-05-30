package com.app.src.util;

// GRASP: Pure Fabrication - PriceFormatter doesn't represent a real-world thing
// It exists purely to centralize reusable price formatting logic
public class PriceFormatter {

    // Utility class — no instantiation needed
    private PriceFormatter() {}

    // Format a raw double into a readable Philippine Peso string
    // e.g. 1200.0 → "₱1,200.00"
    public static String format(double price) {
        return String.format("₱%,.2f", price);
    }

    // Format with a discount applied
    // e.g. 1200.0, 10.0 → "₱1,080.00"
    public static String formatWithDiscount(double price, double discountPercent) {
        double discounted = price - (price * discountPercent / 100);
        return format(discounted);
    }

    // Check if a price is within a given budget
    // e.g. 350.0, 500.0 → true
    public static boolean isWithinBudget(double price, double budget) {
        return price <= budget;
    }

    // Parse a formatted price string back to a double
    // e.g. "₱1,200.00" → 1200.0
    public static double parse(String formattedPrice) {
        String cleaned = formattedPrice
                .replace("₱", "")
                .replace(",", "")
                .trim();
        return Double.parseDouble(cleaned);
    }
}