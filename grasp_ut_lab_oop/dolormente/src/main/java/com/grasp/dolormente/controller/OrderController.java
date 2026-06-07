package com.grasp.dolormente.controller;

import com.grasp.dolormente.dto.OrderRequestDTO;
import com.grasp.dolormente.entity.Order;

import com.grasp.dolormente.service.OrderService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    // GRASP: Controller
    public OrderController(
            OrderService service
    ) {
        this.service = service;
    }

    @PostMapping
    public Order createOrder(
            @RequestBody
            OrderRequestDTO dto
    ) {

        return service.createOrder(dto);
    }

    @GetMapping("/{id}")
    public Order getOrder(
            @PathVariable Long id
    ) {

        return service.getOrder(id);
    }
}