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

@ExtendWith(MockitoExtension.class)
@DisplayName("OrderService Unit Tests")
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private Map<String, Payment> paymentStrategies;

    @Mock
    private Payment cashPayment;

    @InjectMocks
    private OrderService orderService;

    private Order sampleOrder;
    private OrderDTO.OrderRequest validRequest;
    private OrderDTO.OrderResponse sampleResponse;

    @BeforeEach
    void setUp() {
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

        validRequest = OrderDTO.OrderRequest.builder()
                .customerName("Jophel Plantilla")
                .paymentType("CASH")
                .items(List.of(
                        OrderDTO.OrderItemRequest.builder()
                                .productName("Laptop")
                                .price(50000.0)
                                .quantity(1)
                                .build()
                ))
                .build();

        sampleResponse = OrderDTO.OrderResponse.builder()
                .id(1L)
                .customerName("Jophel Plantilla")
                .status("PENDING")
                .totalAmount(50000.0)
                .build();
    }

    // Test 1
    @Test
    @DisplayName("Should successfully create an order")
    void shouldCreateOrder() {
        when(paymentStrategies.getOrDefault(anyString(), any())).thenReturn(cashPayment);
        when(paymentStrategies.get("cashPayment")).thenReturn(cashPayment);
        when(orderRepository.save(any(Order.class))).thenReturn(sampleOrder);
        when(orderMapper.toResponse(any(Order.class))).thenReturn(sampleResponse);
        doNothing().when(cashPayment).process(anyDouble());

        OrderDTO.OrderResponse result = orderService.createOrder(validRequest);

        assertThat(result).isNotNull();
        assertThat(result.getCustomerName()).isEqualTo("Jophel Plantilla");
        verify(orderRepository, times(1)).save(any(Order.class));
    }

    // Test 2
    @Test
    @DisplayName("Should return order when found by ID")
    void shouldReturnOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(sampleOrder));
        when(orderMapper.toResponse(sampleOrder)).thenReturn(sampleResponse);

        OrderDTO.OrderResponse result = orderService.getOrderById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
    }

    // Test 3
    @Test
    @DisplayName("Should throw OrderNotFoundException when order does not exist")
    void shouldThrowExceptionWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> orderService.getOrderById(99L))
                .isInstanceOf(OrderNotFoundException.class)
                .hasMessageContaining("99");
    }

    // Test 4
    @Test
    @DisplayName("Should delete an order successfully")
    void shouldDeleteOrder() {
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }

    // Test 5
    @Test
    @DisplayName("Should throw when customer name is null")
    void shouldThrowWhenCustomerNameIsNull() {
        OrderDTO.OrderRequest badRequest = OrderDTO.OrderRequest.builder()
                .customerName(null)
                .items(List.of(
                        OrderDTO.OrderItemRequest.builder()
                                .productName("Phone")
                                .price(15000.0)
                                .quantity(1)
                                .build()
                ))
                .build();

        assertThatThrownBy(() -> orderService.createOrder(badRequest))
                .isInstanceOf(InvalidOrderException.class)
                .hasMessageContaining("Customer name");
    }
}