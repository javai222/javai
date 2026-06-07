package com.grasp.dolormente.service;

import com.grasp.dolormente.dto.OrderRequestDTO;
import com.grasp.dolormente.entity.Order;

public interface OrderService {

    Order createOrder(OrderRequestDTO dto);

    Order getOrder(Long id);

}