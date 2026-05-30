package com.casapao.orders.app.dto;

import java.util.List;

public class OrderRequest {

    private List<ItemDTO> items;

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public static class ItemDTO {

        private String productName;
        private int quantity;
        private double price;

        public String getProductName() { return productName; }
        public int getQuantity() { return quantity; }
        public double getPrice() { return price; }

        public void setProductName(String productName) { this.productName = productName; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
        public void setPrice(double price) { this.price = price; }
    }
}