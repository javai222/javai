package com.silva.productsact.product_app.Repository;

import com.silva.productsact.product_app.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// High Cohesion was also highlight here as it focuses in CRUD Mechanisms

// GRASP Protected Variation was observed here as this extension protects the project from database variation
@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
}