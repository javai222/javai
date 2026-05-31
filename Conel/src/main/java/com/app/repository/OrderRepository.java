package com.app.repository;

import com.app.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection - Repository acts as layer between DB and Service
public interface OrderRepository extends JpaRepository<Order, Long> {
}
