package com.casapao.orders.app.service;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.mapper.OrderMapper;
import com.casapao.orders.app.repository.OrderRepository;
import com.casapao.orders.app.util.OrderValidator;
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

    @Mock
    private OrderValidator validator;

    @Mock
    private OrderMapper mapper;

    @InjectMocks
    private OrderService service;

    // 1️⃣ CREATE ORDER - HAPPY PATH
    @Test
    void createOrder_shouldReturnResponse() {

        OrderRequest request = new OrderRequest();
        Order order = new Order();
        Order saved = new Order();
        OrderResponse response = new OrderResponse(1L, 100.0);

        when(mapper.toEntity(request)).thenReturn(order);
        when(repository.save(order)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        OrderResponse result = service.createOrder(request);

        assertNotNull(result);
        assertEquals(1L, result.getId());

        verify(validator, times(1)).validate(request);
        verify(mapper, times(1)).toEntity(request);
        verify(repository, times(1)).save(order);
        verify(mapper, times(1)).toResponse(saved);
    }

    // 2️⃣ GET ALL ORDERS
    @Test
    void getAllOrders_shouldReturnList() {

        Order order = new Order();
        OrderResponse response = new OrderResponse(1L, 100.0);

        when(repository.findAll()).thenReturn(List.of(order));
        when(mapper.toResponse(order)).thenReturn(response);

        List<OrderResponse> result = service.getAllOrders();

        assertEquals(1, result.size());
        verify(repository, times(1)).findAll();
    }

    // 3️⃣ VALIDATION CALLED
    @Test
    void createOrder_shouldCallValidator() {

        OrderRequest request = new OrderRequest();
        Order order = new Order();
        Order saved = new Order();
        OrderResponse response = new OrderResponse(1L, 100.0);

        when(mapper.toEntity(request)).thenReturn(order);
        when(repository.save(order)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        service.createOrder(request);

        verify(validator, times(1)).validate(request);
    }

    // 4️⃣ NULL EDGE CASE
    @Test
    void createOrder_shouldHandleNullRequest() {

        when(mapper.toEntity(null)).thenThrow(new IllegalArgumentException());

        assertThrows(IllegalArgumentException.class,
                () -> service.createOrder(null));
    }

    // 5️⃣ REPOSITORY INTERACTION TEST
    @Test
    void createOrder_shouldCallRepositoryOnce() {

        OrderRequest request = new OrderRequest();
        Order order = new Order();
        Order saved = new Order();
        OrderResponse response = new OrderResponse(1L, 100.0);

        when(mapper.toEntity(request)).thenReturn(order);
        when(repository.save(order)).thenReturn(saved);
        when(mapper.toResponse(saved)).thenReturn(response);

        service.createOrder(request);

        verify(repository, times(1)).save(order);
    }
}