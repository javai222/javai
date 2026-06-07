package com.app.dto;

import lombok.*;
import java.util.List;

// GRASP: Pure Fabrication - DTO exists only to transfer data cleanly
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private String customerName;
    private List<ItemDTO> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemDTO {
        private String productName;
        private double price;
        private int quantity;
    }
}
