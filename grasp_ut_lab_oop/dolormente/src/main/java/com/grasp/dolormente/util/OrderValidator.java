package com.grasp.dolormente.util;

import com.grasp.dolormente.dto.OrderRequestDTO;

import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    // GRASP: High Cohesion
    public void validate(OrderRequestDTO dto) {

        if (dto == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null"
            );
        }

        if (dto.getItems() == null ||
                dto.getItems().isEmpty()) {

            throw new IllegalArgumentException(
                    "Items cannot be empty"
            );
        }
    }
}