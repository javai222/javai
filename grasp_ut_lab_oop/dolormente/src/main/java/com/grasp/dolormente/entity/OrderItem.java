package com.grasp.dolormente.entity;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private int quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(
            String productName,
            int quantity,
            double price
    ) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // GRASP: Information Expert
    public double calculateSubtotal() {
        return quantity * price;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}