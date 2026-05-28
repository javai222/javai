package com.silva.productsact.product_app.dto;
// GRASP Pure Fabrication was observed here
public class ProductDto {
    private String name;
    private double productPrice;

    public ProductDto() {
    }

    public ProductDto(String name, double productPrice) {
        this.name = name;
        this.productPrice = productPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}

