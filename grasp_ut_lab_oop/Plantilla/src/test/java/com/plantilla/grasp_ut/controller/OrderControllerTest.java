package com.plantilla.grasp_ut.controller;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.service.OrderService;
import com.plantilla.grasp_ut.util.OrderNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
@DisplayName("OrderController Unit Tests")
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    private OrderDTO.OrderResponse sampleResponse;
    private OrderDTO.OrderRequest validRequest;

    @BeforeEach
    void setUp() {
        sampleResponse = OrderDTO.OrderResponse.builder()
                .id(1L)
                .customerName("Jophel Plantilla")
                .status("PENDING")
                .totalAmount(50000.0)
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
    }

    // Test 1
    @Test
    @DisplayName("POST /api/orders should return 201")
    void shouldReturn201WhenCreatingOrder() throws Exception {
        when(orderService.createOrder(any())).thenReturn(sampleResponse);
        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Jophel Plantilla"));
    }

    // Test 2
    @Test
    @DisplayName("GET /api/orders should return 200")
    void shouldReturn200WithAllOrders() throws Exception {
        when(orderService.getAllOrders()).thenReturn(List.of(sampleResponse));
        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").value("Jophel Plantilla"));
    }

    // Test 3
    @Test
    @DisplayName("GET /api/orders/{id} should return 404 when not found")
    void shouldReturn404WhenOrderNotFound() throws Exception {
        when(orderService.getOrderById(99L)).thenThrow(new OrderNotFoundException(99L));
        mockMvc.perform(get("/api/orders/99"))
                .andExpect(status().isNotFound());
    }
}