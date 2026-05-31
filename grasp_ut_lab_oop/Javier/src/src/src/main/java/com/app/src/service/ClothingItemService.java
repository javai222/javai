package com.app.src.service;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.app.src.entity.ClothingItem;
import com.app.src.repository.ClothingItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClothingItemService {

    private final ClothingItemRepository clothingItemRepository;
    private ClothingDiscountPolicy discountPolicy = new NoDiscountPolicy();

    public ClothingItemService(ClothingItemRepository clothingItemRepository) {
        this.clothingItemRepository = clothingItemRepository;
    }

    public ClothingItem createClothingItem(ClothingItem item) {
        if (!item.isValid()) {
            throw new RuntimeException("Invalid clothing item: name is required and price must be non-negative.");
        }
        return clothingItemRepository.save(item);
    }

    public ClothingItem getClothingItem(Long id) {
        return clothingItemRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing item not found with id: " + id));
    }

    public List<ClothingItem> getAllClothingItems() {
        return clothingItemRepository.findAll();
    }

    public ClothingItem updateClothingItem(Long id, ClothingItem updated) {
        ClothingItem existing = getClothingItem(id);
        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setSize(updated.getSize());
        existing.setColor(updated.getColor());
        existing.setPrice(updated.getPrice());
        existing.setImageUrl(updated.getImageUrl());
        existing.setNotes(updated.getNotes());
        return clothingItemRepository.save(existing);
    }

    public void deleteClothingItem(Long id) {
        clothingItemRepository.deleteById(id);
    }

    public List<ClothingItem> filterItems(String category, String size, String color) {
        return clothingItemRepository.findByCategoryAndSizeAndColor(category, size, color);
    }

    public List<ClothingItem> getAffordableItems(double budget) {
        return clothingItemRepository.findByPriceLessThanEqual(budget);
    }

    public void setDiscountPolicy(ClothingDiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public double getDiscountedPrice(ClothingItem item) {
        return discountPolicy.apply(item);
    }

    public String getDiscountDescription() {
        return discountPolicy.getDescription();
    }
}