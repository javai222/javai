package com.plantilla.grasp_ut.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Information Expert - Order owns items so it calculates the total
// Creator - Order creates its own OrderItem objects
@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String customerName;

    // Status can be PENDING, CONFIRMED, or CANCELLED
    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // Information Expert - Order owns this list
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    // Information Expert
    // Order has the items so it is the best place to calculate total
    public double calculateTotal() {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
        return items.stream()
                .mapToDouble(OrderItem::getSubtotal)
                .sum();
    }

    // Creator
    // Order creates its own OrderItems because it has all the needed data
    public void addItem(String productName, double price, int quantity) {
        OrderItem item = OrderItem.builder()
                .productName(productName)
                .price(price)
                .quantity(quantity)
                .order(this)
                .build();
        this.items.add(item);
    }

    // Set default values before saving to database
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.status == null) {
            this.status = "PENDING";
        }
    }
}