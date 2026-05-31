package com.casapao.orders.app.service.impl;

import com.casapao.orders.app.dto.ItemDTO;
import com.casapao.orders.app.dto.OrderRequest;
import com.casapao.orders.app.dto.OrderResponse;
import com.casapao.orders.app.entity.Order;
import com.casapao.orders.app.entity.OrderItem;
import com.casapao.orders.app.repository.OrderRepository;
import com.casapao.orders.app.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {

        Order order = new Order();

        List<OrderItem> items = request.getItems().stream()
                .map(item -> {
                    OrderItem oi = new OrderItem();
                    oi.setProductName(item.getProductName());
                    oi.setQuantity(item.getQuantity());
                    oi.setPrice(item.getPrice());

                    // IMPORTANT: relationship fix
                    oi.setOrder(order);

                    return oi;
                })
                .toList();

        order.setItems(items);

        Order saved = repository.save(order);

        return new OrderResponse(
                saved.getId(),
                saved.calculateTotal(),
                saved.getItems().stream()
                        .map(i -> new ItemDTO(
                                i.getProductName(),
                                i.getQuantity(),
                                i.getPrice()
                        ))
                        .toList()
        );
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return repository.findAll()
                .stream()
                .map(o -> new OrderResponse(
                        o.getId(),
                        o.calculateTotal(),
                        o.getItems().stream()
                                .map(i -> new ItemDTO(
                                        i.getProductName(),
                                        i.getQuantity(),
                                        i.getPrice()
                                ))
                                .toList()
                ))
                .toList();
    }
}