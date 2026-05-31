package com.plantilla.grasp_ut.entity;

import jakarta.persistence.*;
import lombok.*;

// Information Expert
// OrderItem owns price and quantity so it calculates its own subtotal
@Entity
@Table(name = "order_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productName;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int quantity;

    // Each item belongs to one order
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    // Information Expert
    // This class owns price and quantity so subtotal calculation belongs here
    public double getSubtotal() {
        return price * quantity;
    }
}