package com.cantela.fullstackApp.Repository;

import com.cantela.fullstackApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
