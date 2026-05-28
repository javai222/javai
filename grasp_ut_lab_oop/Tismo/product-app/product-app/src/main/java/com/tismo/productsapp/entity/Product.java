package com.tismo.productsapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    // GRASP: Information Expert - Product owns and manages product data
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProductItem> items = new ArrayList<>();

    // GRASP: Creator - Product is responsible for creating/managing ProductItems
    public void addItem(String itemName, int quantity) {
        this.items.add(new ProductItem(itemName, quantity));
    }

    // GRASP: Information Expert - Product calculates total value
    public double calculateTotalValue() {
        return items.stream()
                .mapToDouble(i -> i.getQuantity() * price)
                .sum();
    }

}