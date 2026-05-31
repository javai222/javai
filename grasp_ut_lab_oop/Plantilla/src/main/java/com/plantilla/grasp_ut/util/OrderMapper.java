package com.plantilla.grasp_ut.util;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Pure Fabrication
// Does not represent a real world thing
// Only exists to handle converting entities to DTOs
// High Cohesion - only responsible for mapping
@Component
public class OrderMapper {

    // Convert one Order to OrderResponse
    public OrderDTO.OrderResponse toResponse(Order order) {
        List<OrderDTO.OrderItemResponse> itemResponses = order.getItems() == null
                ? Collections.emptyList()
                : order.getItems().stream()
                .map(this::toItemResponse)
                .collect(Collectors.toList());

        return OrderDTO.OrderResponse.builder()
                .id(order.getId())
                .customerName(order.getCustomerName())
                .status(order.getStatus())
                .totalAmount(order.calculateTotal())
                .items(itemResponses)
                .createdAt(order.getCreatedAt() != null ? order.getCreatedAt().toString() : null)
                .build();
    }

    // Convert one OrderItem to OrderItemResponse
    public OrderDTO.OrderItemResponse toItemResponse(OrderItem item) {
        return OrderDTO.OrderItemResponse.builder()
                .id(item.getId())
                .productName(item.getProductName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .subtotal(item.getSubtotal())
                .build();
    }

    // Convert list of Orders to list of OrderResponse
    public List<OrderDTO.OrderResponse> toResponseList(List<Order> orders) {
        if (orders == null || orders.isEmpty()) {
            return Collections.emptyList();
        }
        return orders.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}