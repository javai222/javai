package com.nu_bscs.b.repository;

import com.nu_bscs.b.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find by name
    List<Product> findByName(String name);

    // Find by category
    List<Product> findByCategory(String category);

    // Find by price range
    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Find by stock greater than
    List<Product> findByStockGreaterThan(Integer stock);

    // Search by name containing keyword
    List<Product> findByNameContainingIgnoreCase(String keyword);

}