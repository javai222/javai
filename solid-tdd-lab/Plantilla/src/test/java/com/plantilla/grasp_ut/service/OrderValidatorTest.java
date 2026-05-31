package com.plantilla.grasp_ut.service;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.util.InvalidOrderException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

// SOLID: SRP - Tests only the validator
@DisplayName("OrderValidator Tests")
class OrderValidatorTest {

    private OrderValidator orderValidator;

    @BeforeEach
    void setUp() {
        orderValidator = new OrderValidator();
    }

    // Test 3 - SRP
    @Test
    @DisplayName("Should pass for valid request")
    void shouldPassForValidRequest() {
        OrderDTO.OrderRequest request = OrderDTO.OrderRequest.builder()
                .customerName("Jophel")
                .items(List.of(OrderDTO.OrderItemRequest.builder()
                        .productName("Laptop").price(50000.0).quantity(1).build()))
                .build();

        assertThatNoException().isThrownBy(() -> orderValidator.validateRequest(request));
    }

    // Test 4 - Edge case
    @Test
    @DisplayName("Should throw when customer name is null")
    void shouldThrowWhenCustomerNameNull() {
        assertThatThrownBy(() -> orderValidator.validateCustomerName(null))
                .isInstanceOf(InvalidOrderException.class);
    }
}