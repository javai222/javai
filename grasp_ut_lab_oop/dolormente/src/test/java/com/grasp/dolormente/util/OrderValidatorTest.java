package com.grasp.dolormente.util;

import com.grasp.dolormente.dto.OrderRequestDTO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderValidatorTest {

    private final OrderValidator validator =
            new OrderValidator();

    @Test
    void shouldThrowWhenDtoIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(null)
        );
    }

    @Test
    void shouldThrowWhenItemsEmpty() {

        OrderRequestDTO dto =
                new OrderRequestDTO();

        dto.setItems(List.of());

        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate(dto)
        );
    }
}