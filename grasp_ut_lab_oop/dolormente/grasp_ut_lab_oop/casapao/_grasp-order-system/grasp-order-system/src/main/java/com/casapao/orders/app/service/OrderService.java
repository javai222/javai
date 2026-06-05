package com.casapao.orders.app.service;

import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.entity.OrderItem;
import com.casapao.orders.app.repository.OrderRepository;
import com.casapao.orders.app.util.OrderValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public OrderResponse createOrder(OrderRequest request) {

        OrderValidator.validate(request);

        Order order = new Order();

        order.setItems(
                request.getItems()
                        .stream()
                        .map(item -> {
                            OrderItem orderItem = new OrderItem();
                            orderItem.setProductName(item.productName);
                            orderItem.setQuantity(item.quantity);
                            orderItem.setPrice(item.price);
                            return orderItem;
                        })
                        .collect(Collectors.toList())
        );

        Order savedOrder = repository.save(order);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.calculateTotal()
        );
    }

    public List<OrderResponse> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(order -> new OrderResponse(
                        order.getId(),
                        order.calculateTotal()
                ))
                .collect(Collectors.toList());
    }
}