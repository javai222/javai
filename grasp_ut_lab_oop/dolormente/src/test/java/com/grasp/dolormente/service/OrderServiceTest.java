package com.grasp.dolormente.service;

import com.grasp.dolormente.dto.OrderItemDTO;
import com.grasp.dolormente.dto.OrderRequestDTO;

import com.grasp.dolormente.entity.Order;
import com.grasp.dolormente.entity.OrderItem;

import com.grasp.dolormente.exception.ResourceNotFoundException;

import com.grasp.dolormente.repository.OrderRepository;

import com.grasp.dolormente.service.impl.OrderServiceImpl;

import com.grasp.dolormente.util.OrderValidator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @Mock
    private OrderValidator validator;

    @InjectMocks
    private OrderServiceImpl service;

    @Test
    void shouldCreateOrder() {

        OrderItemDTO item =
                new OrderItemDTO();

        item.setProductName("Laptop");
        item.setQuantity(2);
        item.setPrice(1000);

        OrderRequestDTO dto =
                new OrderRequestDTO();

        dto.setCustomerName("Henry");
        dto.setItems(List.of(item));

        Order saved =
                new Order("Henry");

        when(repository.save(any(Order.class)))
                .thenReturn(saved);

        Order result =
                service.createOrder(dto);

        assertEquals(
                "Henry",
                result.getCustomerName()
        );

        verify(repository, times(1))
                .save(any(Order.class));
    }

    @Test
    void shouldThrowWhenOrderNotFound() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.getOrder(1L)
        );
    }

    @Test
    void shouldCalculateTotal() {

        Order order =
                new Order("Henry");

        order.addItem(
                new OrderItem(
                        "Phone",
                        2,
                        500
                )
        );

        assertEquals(
                1000,
                order.calculateTotal()
        );
    }

    @Test
    void shouldRejectEmptyItems() {

        OrderRequestDTO dto =
                new OrderRequestDTO();

        dto.setItems(List.of());

        doThrow(
                new IllegalArgumentException(
                        "Items cannot be empty"
                )
        ).when(validator).validate(dto);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createOrder(dto)
        );
    }

    @Test
    void shouldRejectNullRequest() {

        doThrow(
                new IllegalArgumentException(
                        "Order cannot be null"
                )
        ).when(validator).validate(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createOrder(null)
        );
    }
}