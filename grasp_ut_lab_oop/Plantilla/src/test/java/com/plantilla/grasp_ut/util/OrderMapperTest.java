package com.plantilla.grasp_ut.util;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.entity.OrderItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("OrderMapper Tests")
class OrderMapperTest {

    private OrderMapper orderMapper;
    private Order sampleOrder;

    @BeforeEach
    void setUp() {
        orderMapper = new OrderMapper();

        OrderItem item = OrderItem.builder()
                .id(1L)
                .productName("Laptop")
                .price(50000.0)
                .quantity(1)
                .build();

        sampleOrder = Order.builder()
                .id(1L)
                .customerName("Jophel Plantilla")
                .status("PENDING")
                .createdAt(LocalDateTime.now())
                .items(new ArrayList<>(List.of(item)))
                .build();
    }

    // Test 1
    @Test
    @DisplayName("Should map Order to OrderResponse correctly")
    void shouldMapOrderToResponse() {
        OrderDTO.OrderResponse response = orderMapper.toResponse(sampleOrder);
        assertThat(response).isNotNull();
        assertThat(response.getId()).isEqualTo(1L);
        assertThat(response.getCustomerName()).isEqualTo("Jophel Plantilla");
        assertThat(response.getTotalAmount()).isEqualTo(50000.0);
    }

    // Test 2
    @Test
    @DisplayName("Should return empty list for empty orders")
    void shouldReturnEmptyListForEmptyOrders() {
        List<OrderDTO.OrderResponse> result = orderMapper.toResponseList(Collections.emptyList());
        assertThat(result).isEmpty();
    }
}