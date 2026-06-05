package com.grasp.dolormente.repository;

import com.grasp.dolormente.entity.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection
@Repository
public interface OrderRepository
        extends JpaRepository<Order, Long> {
}