package com.app.src.repository;

import com.app.src.entity.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClothingItemRepository extends JpaRepository<ClothingItem, Long> {
    List<ClothingItem> findByCategory(String category);
    List<ClothingItem> findBySize(String size);
    List<ClothingItem> findByColor(String color);
    List<ClothingItem> findByCategoryAndSizeAndColor(String category, String size, String color);
    List<ClothingItem> findByPriceLessThanEqual(double budget);
}