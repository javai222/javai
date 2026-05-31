package com.plantilla.grasp_ut.service;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.util.InvalidOrderException;
import org.springframework.stereotype.Component;
import java.util.List;

// SOLID: SRP - it is only for validating orders
// DRY: All validation logic is in one place
// KISS: Each method does one simple check
@Component
public class OrderValidator {

    // DRY: Reusable method used by OrderService
    public void validateRequest(OrderDTO.OrderRequest request) {
        validateCustomerName(request.getCustomerName());
        validateItems(request.getItems());
    }

    // SOLID: SRP - only validates customer name
    public void validateCustomerName(String customerName) {
        if (customerName == null || customerName.isBlank()) {
            throw new InvalidOrderException("Customer name must not be empty");
        }
    }

    // SOLID: SRP - only validates items list
    public void validateItems(List<OrderDTO.OrderItemRequest> items) {
        if (items == null || items.isEmpty()) {
            throw new InvalidOrderException("Order must have at least one item");
        }
    }

    // SOLID: SRP - only validates a single item
    public void validateItem(OrderDTO.OrderItemRequest item) {
        if (item.getProductName() == null || item.getProductName().isBlank()) {
            throw new InvalidOrderException("Product name must not be empty");
        }
        if (item.getPrice() < 0) {
            throw new InvalidOrderException("Price must not be negative");
        }
        if (item.getQuantity() <= 0) {
            throw new InvalidOrderException("Quantity must be greater than zero");
        }
    }
}