package com.app.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;
    private double price;
    private int quantity;

    // GRASP: Information Expert - OrderItem knows its own subtotal
    public double getSubtotal() {
        return price * quantity;
    }
}
