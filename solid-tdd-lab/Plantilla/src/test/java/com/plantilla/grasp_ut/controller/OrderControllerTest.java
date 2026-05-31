package com.plantilla.grasp_ut.controller;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.service.OrderService;
import com.plantilla.grasp_ut.util.OrderNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// SOLID: DIP - Controller depends on OrderService interface
@WebMvcTest(OrderController.class)
@DisplayName("OrderController Tests")
class OrderControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private OrderService orderService;

    private OrderDTO.OrderResponse sampleResponse;

    @BeforeEach
    void setUp() {
        sampleResponse = OrderDTO.OrderResponse.builder()
                .id(1L).customerName("Jophel Plantilla")
                .status("PENDING").totalAmount(50000.0).build();
    }

    // Test 11
    @Test
    @DisplayName("GET /api/orders should return 200")
    void shouldReturn200WithAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(List.of(sampleResponse));
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk());
    }

    // Test 12
    @Test
    @DisplayName("GET /api/orders/99 should return 404")
    void shouldReturn404WhenNotFound() throws Exception {
        when(orderService.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));
        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound());
    }
}