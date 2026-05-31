package com.casapao.orders.app.dto;

import java.util.List;

public class OrderResponse {

    private Long id;
    private double total;
    private List<ItemDTO> items;

    public OrderResponse(Long id, double total, List<ItemDTO> items) {
        this.id = id;
        this.total = total;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }
}