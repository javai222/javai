package com.tismo.productsapp.dto;

// OOP Best Practice: Immutability - Receipt state cannot be changed after creation
public final class Receipt {

    private final String productName;
    private final double total;

    public Receipt(String productName, double total) {
        this.productName = productName;
        this.total = total;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotal() {
        return total;
    }
}