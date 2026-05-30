package com.casapao.orders.app.repository;

import com.casapao.orders.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection
public interface OrderRepository extends JpaRepository<Order, Long> {
}