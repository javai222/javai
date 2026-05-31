package com.plantilla.grasp_ut.service;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.entity.Order;
import com.plantilla.grasp_ut.entity.OrderItem;
import com.plantilla.grasp_ut.repository.OrderRepository;
import com.plantilla.grasp_ut.util.InvalidOrderException;
import com.plantilla.grasp_ut.util.OrderMapper;
import com.plantilla.grasp_ut.util.OrderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

// SOLID: DIP - mocking interfaces not concrete implementations
@ExtendWith(MockitoExtension.class)
@DisplayName("OrderService Tests")
class OrderServiceTest {

    @Mock private OrderRepository orderRepository;
    @Mock private OrderMapper orderMapper;
    @Mock private Map<String, Payment> paymentStrategies;
    @Mock private Payment cashPayment;
    @Mock private OrderValidator orderValidator;

    @InjectMocks
    private OrderService orderService;

    private Order sampleOrder;
    private OrderDTO.OrderRequest validRequest;
    private OrderDTO.OrderResponse sampleResponse;

    @BeforeEach
    void setUp() {
        OrderItem item = OrderItem.builder()
                .id(1L).productName("Laptop").price(50000.0).quantity(1).build();

        sampleOrder = Order.builder()
                .id(1L).customerName("Jophel Plantilla").status("PENDING")
                .createdAt(LocalDateTime.now())
                .items(new ArrayList<>(List.of(item))).build();

        validRequest = OrderDTO.OrderRequest.builder()
                .customerName("Jophel Plantilla").paymentType("CASH")
                .items(List.of(OrderDTO.OrderItemRequest.builder()
                        .productName("Laptop").price(50000.0).quantity(1).build()))
                .build();

        sampleResponse = OrderDTO.OrderResponse.builder()
                .id(1L).customerName("Jophel Plantilla")
                .status("PENDING").totalAmount(50000.0).build();
    }

    // Test 1 - SOLID SRP
    @Test
    @DisplayName("Should create order successfully")
    void shouldCreateOrder() {
        doNothing().when(orderValidator).validateRequest(any());
        doNothing().when(orderValidator).validateItem(any());
        when(paymentStrategies.getOrDefault(anyString(), any())).thenReturn(cashPayment);
        when(paymentStrategies.get("cashPayment")).thenReturn(cashPayment);
        when(orderRepository.save(any(Order.class))).thenReturn(sampleOrder);
        when(orderMapper.toResponse(any(Order.class))).thenReturn(sampleResponse);
        doNothing().when(cashPayment).process(anyDouble());

        OrderDTO.OrderResponse result = orderService.createOrder(validRequest);
        assertThat(result).isNotNull();
        assertThat(result.getCustomerName()).isEqualTo("Jophel Plantilla");
    }

    // Test 2 - Edge case
    @Test
    @DisplayName("Should throw when order not found")
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> orderService.getOrderById(99L))
                .isInstanceOf(OrderNotFoundException.class);
    }
}