package com.casapao.orders.app.service;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.repository.OrderRepository;
import com.casapao.orders.app.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderServiceImpl service;

    // ✅ 1
    @Test
    void shouldReturnEmptyList() {
        when(repository.findAll()).thenReturn(List.of());

        List<OrderResponse> result = service.getAllOrders();

        assertTrue(result.isEmpty());
        verify(repository).findAll();
    }

    // ✅ 2
    @Test
    void shouldCreateOrder() {
        Order order = new Order();
        order.setId(1L);

        when(repository.save(any(Order.class))).thenReturn(order);

        OrderRequest request = new OrderRequest();
        request.setItems(List.of());

        OrderResponse response = service.createOrder(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());

        verify(repository).save(any(Order.class));
    }

    // ✅ 3
    @Test
    void shouldReturnAllOrders() {
        Order order = new Order();
        order.setId(1L);

        when(repository.findAll()).thenReturn(List.of(order));

        List<OrderResponse> result = service.getAllOrders();

        assertEquals(1, result.size());
        verify(repository).findAll();
    }

    // ✅ 4 EDGE CASE
    @Test
    void shouldThrowExceptionWhenRequestIsNull() {
        assertThrows(NullPointerException.class, () -> service.createOrder(null));
    }

    // ✅ 5 EDGE CASE
    @Test
    void shouldHandleNullItemsList() {
        OrderRequest request = new OrderRequest();
        request.setItems(null);

        assertThrows(NullPointerException.class, () -> service.createOrder(request));
    }

    // ✅ 6 EDGE CASE
    @Test
    void shouldHandleEmptyItemsList() {
        Order order = new Order();
        order.setId(1L);

        when(repository.save(any(Order.class))).thenReturn(order);

        OrderRequest request = new OrderRequest();
        request.setItems(List.of());

        OrderResponse response = service.createOrder(request);

        assertNotNull(response);
        verify(repository).save(any(Order.class));
    }

    // ✅ 7 EXTRA SAFETY TEST
    @Test
    void shouldVerifyRepositoryInteractions() {
        Order order = new Order();
        order.setId(1L);

        when(repository.save(any(Order.class))).thenReturn(order);

        OrderRequest request = new OrderRequest();
        request.setItems(List.of());

        service.createOrder(request);

        verify(repository, times(1)).save(any(Order.class));
    }

    // ✅ 8 LIST EDGE CASE
    @Test
    void shouldReturnZeroWhenNoOrdersExist() {
        when(repository.findAll()).thenReturn(List.of());

        List<OrderResponse> result = service.getAllOrders();

        assertEquals(0, result.size());
    }
}