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

        public String productName;
        public int quantity;
        public double price;
    }
}