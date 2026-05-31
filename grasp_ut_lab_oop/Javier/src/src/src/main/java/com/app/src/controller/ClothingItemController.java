package com.app.src.controller;

import com.app.src.dto.ClothingItemRequestDTO;
import com.app.src.dto.ClothingItemResponseDTO;
import com.app.src.entity.ClothingItem;
import com.app.src.service.ClothingItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clothing-items")
public class ClothingItemController {

    private final ClothingItemService clothingItemService;

    public ClothingItemController(ClothingItemService clothingItemService) {
        this.clothingItemService = clothingItemService;
    }

    @PostMapping
    public ResponseEntity<ClothingItemResponseDTO> createClothingItem(
            @RequestBody ClothingItemRequestDTO requestDTO) {
        ClothingItem item = new ClothingItem();
        item.setName(requestDTO.getName());
        item.setCategory(requestDTO.getCategory());
        item.setSize(requestDTO.getSize());
        item.setColor(requestDTO.getColor());
        item.setPrice(requestDTO.getPrice());
        item.setImageUrl(requestDTO.getImageUrl());
        item.setNotes(requestDTO.getNotes());
        ClothingItem saved = clothingItemService.createClothingItem(item);
        ClothingItemResponseDTO body = ClothingItemResponseDTO.fromEntity(saved);
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping
    public ResponseEntity<List<ClothingItemResponseDTO>> getAllClothingItems() {
        List<ClothingItemResponseDTO> result = clothingItemService.getAllClothingItems()
                .stream()
                .map(ClothingItemResponseDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingItemResponseDTO> getClothingItem(@PathVariable Long id) {
        ClothingItemResponseDTO body = ClothingItemResponseDTO.fromEntity(clothingItemService.getClothingItem(id));
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothingItemResponseDTO> updateClothingItem(
            @PathVariable Long id,
            @RequestBody ClothingItemRequestDTO requestDTO) {
        ClothingItem updated = new ClothingItem();
        updated.setName(requestDTO.getName());
        updated.setCategory(requestDTO.getCategory());
        updated.setSize(requestDTO.getSize());
        updated.setColor(requestDTO.getColor());
        updated.setPrice(requestDTO.getPrice());
        updated.setImageUrl(requestDTO.getImageUrl());
        updated.setNotes(requestDTO.getNotes());
        ClothingItemResponseDTO body = ClothingItemResponseDTO.fromEntity(clothingItemService.updateClothingItem(id, updated));
        return ResponseEntity.ok(body);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothingItem(@PathVariable Long id) {
        clothingItemService.deleteClothingItem(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ClothingItemResponseDTO>> filterItems(
            @RequestParam(defaultValue = "") String category,
            @RequestParam(defaultValue = "") String size,
            @RequestParam(defaultValue = "") String color) {
        List<ClothingItemResponseDTO> result = clothingItemService.filterItems(category, size, color)
                .stream()
                .map(ClothingItemResponseDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/affordable")
    public ResponseEntity<List<ClothingItemResponseDTO>> getAffordableItems(
            @RequestParam double budget) {
        List<ClothingItemResponseDTO> result = clothingItemService.getAffordableItems(budget)
                .stream()
                .map(ClothingItemResponseDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}