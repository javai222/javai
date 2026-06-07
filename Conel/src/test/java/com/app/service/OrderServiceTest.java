package com.app.service;

import com.app.dto.OrderDTO;
import com.app.entity.Order;
import com.app.repository.OrderRepository;
import com.app.util.OrderNotFoundException;
import com.app.util.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Mock
    Payment payment;

    @InjectMocks
    OrderService orderService;

    @Test
    void shouldCreateOrder() {
        OrderDTO dto = new OrderDTO("Conel", List.of(
                new OrderDTO.ItemDTO("Laptop", 999.99, 1)
        ));
        Order saved = new Order(1L, "Conel", new ArrayList<>());
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        Order result = orderService.createOrder(dto);

        assertNotNull(result);
        assertEquals("Conel", result.getCustomerName());
        verify(orderRepository, times(1)).save(any(Order.class));
        verify(payment, times(1)).process(anyDouble());
    }

    @Test
    void shouldReturnAllOrders() {
        List<Order> orders = List.of(
                new Order(1L, "Conel", new ArrayList<>()),
                new Order(2L, "Smith", new ArrayList<>())
        );
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.getAllOrders();

        assertEquals(2, result.size());
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    void shouldGetOrderById() {
        Order order = new Order(1L, "Conel", new ArrayList<>());
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void shouldThrowWhenOrderNotFound() {
        when(orderRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(99L));
    }

    @Test
    void shouldHandleEmptyItemsList() {
        OrderDTO dto = new OrderDTO("Conel", new ArrayList<>());
        Order saved = new Order(1L, "Conel", new ArrayList<>());
        when(orderRepository.save(any(Order.class))).thenReturn(saved);

        Order result = orderService.createOrder(dto);

        assertNotNull(result);
        assertTrue(result.getItems().isEmpty());
    }

    @Test
    void shouldDeleteOrder() {
        when(orderRepository.existsById(1L)).thenReturn(true);
        doNothing().when(orderRepository).deleteById(1L);

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistentOrder() {
        when(orderRepository.existsById(99L)).thenReturn(false);

        assertThrows(OrderNotFoundException.class, () -> orderService.deleteOrder(99L));
    }
}
