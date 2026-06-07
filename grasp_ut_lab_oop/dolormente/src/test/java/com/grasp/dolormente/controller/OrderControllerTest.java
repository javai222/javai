package com.grasp.dolormente.controller;

import com.grasp.dolormente.entity.Order;

import com.grasp.dolormente.service.OrderService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService service;

    @Test
    void shouldReturnOrder()
            throws Exception {

        Order order =
                new Order("Henry");

        when(service.getOrder(1L))
                .thenReturn(order);

        mockMvc.perform(
                        get("/orders/1")
                )
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateOrder()
            throws Exception {

        Order order =
                new Order("Henry");

        when(service.createOrder(
                org.mockito.ArgumentMatchers.any()
        )).thenReturn(order);

        String requestBody = """
                {
                    "customerName": "Henry",
                    "items": [
                        {
                            "productName": "Laptop",
                            "quantity": 1,
                            "price": 50000
                        }
                    ]
                }
                """;

        mockMvc.perform(
                        post("/orders")
                                .contentType(
                                        MediaType.APPLICATION_JSON
                                )
                                .content(requestBody)
                )
                .andExpect(status().isOk());
    }
}