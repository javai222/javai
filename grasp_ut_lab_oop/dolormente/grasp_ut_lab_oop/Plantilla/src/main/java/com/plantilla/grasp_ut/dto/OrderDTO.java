package com.plantilla.grasp_ut.dto;

import lombok.*;
import java.util.List;

// DTOs transfer data between layers cleanly
// We never expose entity classes directly to the outside
public class OrderDTO {

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class OrderRequest {
        private String customerName;
        private List<OrderItemRequest> items;
        private String paymentType;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class OrderItemRequest {
        private String productName;
        private double price;
        private int quantity;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class OrderResponse {
        private Long id;
        private String customerName;
        private String status;
        private double totalAmount;
        private List<OrderItemResponse> items;
        private String createdAt;
    }

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class OrderItemResponse {
        private Long id;
        private String productName;
        private double price;
        private int quantity;
        private double subtotal;
    }
}