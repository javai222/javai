package com.plantilla.grasp_ut.repository;

import com.plantilla.grasp_ut.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Indirection
// Sits between service and database
// Service never talks to the database directly
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerName(String customerName);
    List<Order> findByStatus(String status);
}