package com.plantilla.grasp_ut.util;

import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.entity.OrderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@DisplayName("Order Entity Tests")
class OrderEntityTest {

    // Test 1
    @Test
    @DisplayName("Order should calculate total correctly")
    void shouldCalculateTotalCorrectly() {
        Order order = Order.builder()
                .customerName("Test")
                .status("PENDING")
                .items(new ArrayList<>())
                .build();
        order.addItem("Laptop", 50000.0, 1);
        order.addItem("Mouse", 500.0, 2);
        assertThat(order.calculateTotal()).isEqualTo(51000.0);
    }

    // Test 2
    @Test
    @DisplayName("OrderItem should calculate subtotal correctly")
    void shouldCalculateSubtotal() {
        OrderItem item = OrderItem.builder()
                .productName("Monitor")
                .price(8000.0)
                .quantity(2)
                .build();
        assertThat(item.getSubtotal()).isEqualTo(16000.0);
    }
}