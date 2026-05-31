package com.casapao.orders.app.util;

import com.casapao.orders.app.dto.OrderRequest;

public class OrderValidator {

    public static void validate(OrderRequest request) {

        if (request == null || request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Order must have items");
        }

        for (OrderRequest.ItemDTO item : request.getItems()) {

            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }

            if (item.getPrice() <= 0) {
                throw new IllegalArgumentException("Price must be greater than 0");
            }

            if (item.getProductName() == null || item.getProductName().isBlank()) {
                throw new IllegalArgumentException("Product name is required");
            }
        }
    }
}