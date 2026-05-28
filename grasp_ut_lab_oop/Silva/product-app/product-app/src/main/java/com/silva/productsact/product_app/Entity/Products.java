package com.silva.productsact.product_app.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double productPrice;

    protected Products() {
    }

    public Products(String name, double productPrice) {
        this.name = name;
        this.productPrice = productPrice;
    }
    // GRASP Information Expert used here. It has the neccessary information to fulfill it.
    public double calculatePriceWithTax(double taxRate) {
        return this.productPrice * (1 + taxRate);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getProductPrice() {
        return productPrice;
    }
}