package com.casapao.orders.app.controller;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public OrderResponse create(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return service.getAllOrders();
    }
}