package com.grasp.dolormente.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(String customerName) {
        this.customerName = customerName;
    }

    // GRASP: Creator
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // GRASP: Information Expert
    public double calculateTotal() {
        return items.stream()
                .mapToDouble(OrderItem::calculateSubtotal)
                .sum();
    }

    public Long getId() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}