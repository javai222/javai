package com.torrefranca.product_management.repository;

import com.torrefranca.product_management.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// GRASP: Indirection
// Repository acts as intermediary between database and service

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}