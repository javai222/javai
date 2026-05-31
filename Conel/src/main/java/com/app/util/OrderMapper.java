package com.app.util;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.entity.OrderItem;

// GRASP: Pure Fabrication - exists only to map between DTO and Entity
public class OrderMapper {

    public static Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setCustomerName(dto.getCustomerName());

        if (dto.getItems() != null) {
            for (OrderDTO.ItemDTO itemDTO : dto.getItems()) {
                OrderItem item = new OrderItem();
                item.setProductName(itemDTO.getProductName());
                item.setPrice(itemDTO.getPrice());
                item.setQuantity(itemDTO.getQuantity());
                order.addItem(item);
            }
        }
        return order;
    }
}
