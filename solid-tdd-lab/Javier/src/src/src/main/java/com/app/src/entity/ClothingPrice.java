package com.app.src.entity;

// OOP: Immutability - value object with final fields, no setters
// OOP: KISS - simple value object with one clear purpose
public final class ClothingPrice {

    // Immutability: final fields cannot be modified after construction
    private final double amount;
    private final String currency;

    public ClothingPrice(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.amount = amount;
        this.currency = "PHP";
    }

    public double getAmount()   { return amount; }
    public String getCurrency() { return currency; }

    // DRY: centralized price formatting, reused instead of duplicating String.format everywhere
    public String getFormatted() {
        return String.format("₱%,.2f", amount);
    }

    // Immutability: returns a NEW object instead of modifying this one
    public ClothingPrice withDiscount(double percentage) {
        return new ClothingPrice(amount - (amount * percentage / 100));
    }
}