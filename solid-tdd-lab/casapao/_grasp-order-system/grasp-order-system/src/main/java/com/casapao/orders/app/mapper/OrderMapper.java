package com.casapao.orders.app.mapper;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setProduct(request.getProduct());
        order.setQuantity(request.getQuantity());
        return order;
    }

    public OrderResponse toResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.calculateTotal()
        );
    }
}