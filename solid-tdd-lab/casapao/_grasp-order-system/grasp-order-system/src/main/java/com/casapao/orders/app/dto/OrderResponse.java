package com.casapao.orders.app.dto;

public class OrderResponse {

    private Long id;

    private double total;

    public OrderResponse(Long id, double total) {
        this.id = id;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }
}