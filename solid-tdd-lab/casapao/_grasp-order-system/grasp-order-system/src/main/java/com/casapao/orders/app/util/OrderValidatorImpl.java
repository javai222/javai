package com.casapao.orders.app.util;

import com.casapao.orders.app.dto.OrderRequest;
import org.springframework.stereotype.Component;

@Component
public class OrderValidatorImpl implements OrderValidator {

    @Override
    public void validate(OrderRequest request) {

        if (request == null) {
            throw new IllegalArgumentException("Order request cannot be null");
        }

        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new IllegalArgumentException("Items cannot be empty");
        }

        for (OrderRequest.ItemDTO item : request.getItems()) {

            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than zero");
            }

            if (item.getPrice() < 0) {
                throw new IllegalArgumentException("Price cannot be negative");
            }
        }
    }
}