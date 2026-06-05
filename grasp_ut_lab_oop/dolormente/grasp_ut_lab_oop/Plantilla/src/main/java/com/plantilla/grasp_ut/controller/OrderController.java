package com.plantilla.grasp_ut.controller;

import com.plantilla.grasp_ut.dto.OrderDTO;
import com.plantilla.grasp_ut.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller
// Only handles HTTP requests, delegates everything to OrderService
// No business logic here at all
// Low Coupling - only depends on OrderService
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // POST /api/orders
    @PostMapping
    public ResponseEntity<OrderDTO.OrderResponse> createOrder(@RequestBody OrderDTO.OrderRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(request));
    }

    // GET /api/orders
    @GetMapping
    public ResponseEntity<List<OrderDTO.OrderResponse>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    // GET /api/orders/{id}
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO.OrderResponse> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    // GET /api/orders/customer/{name}
    @GetMapping("/customer/{name}")
    public ResponseEntity<List<OrderDTO.OrderResponse>> getByCustomer(@PathVariable String name) {
        return ResponseEntity.ok(orderService.getOrdersByCustomer(name));
    }

    // PATCH /api/orders/{id}/status
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrderDTO.OrderResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(id, status));
    }

    // DELETE /api/orders/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}