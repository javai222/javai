package com.grasp.dolormente.service.impl;

import com.grasp.dolormente.dto.OrderItemDTO;
import com.grasp.dolormente.dto.OrderRequestDTO;

import com.grasp.dolormente.entity.Order;
import com.grasp.dolormente.entity.OrderItem;

import com.grasp.dolormente.exception.ResourceNotFoundException;

import com.grasp.dolormente.repository.OrderRepository;

import com.grasp.dolormente.service.OrderService;

import com.grasp.dolormente.util.OrderValidator;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl
        implements OrderService {

    private final OrderRepository repository;
    private final OrderValidator validator;

    // GRASP: Low Coupling
    public OrderServiceImpl(
            OrderRepository repository,
            OrderValidator validator
    ) {
        this.repository = repository;
        this.validator = validator;
    }

    // GRASP: Pure Fabrication
    @Override
    public Order createOrder(
            OrderRequestDTO dto
    ) {

        validator.validate(dto);

        Order order =
                new Order(dto.getCustomerName());

        for (OrderItemDTO itemDTO
                : dto.getItems()) {

            OrderItem item =
                    new OrderItem(
                            itemDTO.getProductName(),
                            itemDTO.getQuantity(),
                            itemDTO.getPrice()
                    );

            order.addItem(item);
        }

        return repository.save(order);
    }

    @Override
    public Order getOrder(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found"
                        ));
    }
}