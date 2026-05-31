package com.app.src.service;

import org.springframework.web.server.ResponseStatusException;
import com.app.src.entity.ClothingItem;
import com.app.src.repository.ClothingItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClothingItemServiceTest {

    @Mock
    private ClothingItemRepository clothingItemRepository;

    @InjectMocks
    private ClothingItemService clothingItemService;

    private ClothingItem sampleItem;

    @BeforeEach
    void setUp() {
        sampleItem = new ClothingItem();
        sampleItem.setId(1L);
        sampleItem.setName("Classic White Tee");
        sampleItem.setCategory("Tops");
        sampleItem.setSize("M");
        sampleItem.setColor("White");
        sampleItem.setPrice(350.00);
        sampleItem.setImageUrl("https://example.com/tee.jpg");
        sampleItem.setNotes("100% cotton");
    }

    @Test
    void testCreateClothingItem_ValidItem_ReturnsSavedItem() {
        when(clothingItemRepository.save(sampleItem)).thenReturn(sampleItem);
        ClothingItem result = clothingItemService.createClothingItem(sampleItem);
        assertNotNull(result);
        assertEquals("Classic White Tee", result.getName());
        verify(clothingItemRepository, times(1)).save(sampleItem);
    }

    @Test
    void testCreateClothingItem_InvalidItem_ThrowsException() {
        ClothingItem invalidItem = new ClothingItem();
        invalidItem.setName("");
        invalidItem.setPrice(350.00);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clothingItemService.createClothingItem(invalidItem);
        });
        assertEquals("Invalid clothing item: name is required and price must be non-negative.", exception.getMessage());
        verify(clothingItemRepository, never()).save(any());
    }

    @Test
    void testGetClothingItem_ExistingId_ReturnsItem() {
        when(clothingItemRepository.findById(1L)).thenReturn(Optional.of(sampleItem));
        ClothingItem result = clothingItemService.getClothingItem(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Classic White Tee", result.getName());
    }

    @Test
    void testGetClothingItem_NonExistingId_ThrowsException() {
        when(clothingItemRepository.findById(99L)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(ResponseStatusException.class, () -> {
            clothingItemService.getClothingItem(99L);
        });
        assertEquals("404 NOT_FOUND \"Clothing item not found with id: 99\"", exception.getMessage());
    }

    @Test
    void testGetAllClothingItems_ReturnsAllItems() {
        ClothingItem item2 = new ClothingItem();
        item2.setId(2L);
        item2.setName("Slim Fit Jeans");
        item2.setPrice(1200.00);
        when(clothingItemRepository.findAll()).thenReturn(List.of(sampleItem, item2));
        List<ClothingItem> result = clothingItemService.getAllClothingItems();
        assertEquals(2, result.size());
        assertEquals("Classic White Tee", result.get(0).getName());
        assertEquals("Slim Fit Jeans", result.get(1).getName());
    }

    @Test
    void testFilterItems_MatchingCriteria_ReturnsFilteredList() {
        when(clothingItemRepository.findByCategoryAndSizeAndColor("Tops", "M", "White"))
                .thenReturn(List.of(sampleItem));
        List<ClothingItem> result = clothingItemService.filterItems("Tops", "M", "White");
        assertEquals(1, result.size());
        assertEquals("Classic White Tee", result.get(0).getName());
    }

    @Test
    void testGetAffordableItems_WithinBudget_ReturnsMatchingItems() {
        when(clothingItemRepository.findByPriceLessThanEqual(500.00))
                .thenReturn(List.of(sampleItem));
        List<ClothingItem> result = clothingItemService.getAffordableItems(500.00);
        assertEquals(1, result.size());
        assertEquals(350.00, result.get(0).getPrice());
    }

    @Test
    void testGetDiscountedPrice_PercentageDiscount_ReturnsDiscountedPrice() {
        // SRP proof: discount logic now belongs to ClothingDiscountService, not ClothingItemService
        ClothingDiscountService discountService = new ClothingDiscountService(new PercentageDiscountPolicy(10));
        double discountedPrice = discountService.getDiscountedPrice(sampleItem);
        assertEquals(315.00, discountedPrice, 0.01);
    }

    @Test
    void testDeleteClothingItem_ValidId_CallsRepository() {
        doNothing().when(clothingItemRepository).deleteById(1L);
        clothingItemService.deleteClothingItem(1L);
        verify(clothingItemRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateClothingItem_ValidId_ReturnsUpdatedItem() {
        ClothingItem updatedData = new ClothingItem();
        updatedData.setName("Updated Tee");
        updatedData.setCategory("Tops");
        updatedData.setSize("L");
        updatedData.setColor("Black");
        updatedData.setPrice(400.00);
        updatedData.setImageUrl("https://example.com/new.jpg");
        updatedData.setNotes("Updated notes");
        when(clothingItemRepository.findById(1L)).thenReturn(Optional.of(sampleItem));
        when(clothingItemRepository.save(any(ClothingItem.class))).thenReturn(sampleItem);
        ClothingItem result = clothingItemService.updateClothingItem(1L, updatedData);
        assertNotNull(result);
        verify(clothingItemRepository, times(1)).save(any(ClothingItem.class));
    }
}