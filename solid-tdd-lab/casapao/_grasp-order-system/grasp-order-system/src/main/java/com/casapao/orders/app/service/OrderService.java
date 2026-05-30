package com.casapao.orders.app.service;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.repository.OrderRepository;
import com.casapao.orders.app.util.OrderValidator;
import com.casapao.orders.app.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderValidator validator;
    private final OrderMapper mapper;

    public OrderService(OrderRepository repository,
                        OrderValidator validator,
                        OrderMapper mapper) {
        this.repository = repository;
        this.validator = validator;
        this.mapper = mapper;
    }

    public OrderResponse createOrder(OrderRequest request) {

        // SRP: validation delegated
        validator.validate(request);

        // SRP: mapping delegated
        Order order = mapper.toEntity(request);

        // DIP: repository injected
        Order saved = repository.save(order);

        // OCP + SRP FIX: response mapping delegated to mapper
        return mapper.toResponse(saved);
    }

    public java.util.List<OrderResponse> getAllOrders() {

        // DIP: repository handles data access
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}