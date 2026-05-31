package com.casapao.orders.app.mapper;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.entity.OrderItem;

import java.util.List;
import java.util.stream.Collectors;

// SOLID: SRP - Handles only object mapping
public class OrderMapper {

    public static Order toEntity(OrderRequest request) {

        Order order = new Order();

        List<OrderItem> items = request.getItems()
                .stream()
                .map(OrderMapper::toOrderItem)
                .collect(Collectors.toList());

        order.setItems(items);

        return order;
    }

    private static OrderItem toOrderItem(OrderRequest.ItemDTO dto) {
        OrderItem item = new OrderItem();
        item.setProductName(dto.getProductName());
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }
}