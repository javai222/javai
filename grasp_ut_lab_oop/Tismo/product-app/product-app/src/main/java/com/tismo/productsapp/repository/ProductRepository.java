package com.tismo.productsapp.repository;

import com.tismo.productsapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// GRASP: Indirection - Acts as intermediary between service and database
public interface ProductRepository extends JpaRepository<Product, Long> {
}