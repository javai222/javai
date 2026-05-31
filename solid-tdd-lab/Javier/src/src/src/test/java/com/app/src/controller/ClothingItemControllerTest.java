package com.app.src.controller;

import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import com.app.src.dto.ClothingItemRequestDTO;
import com.app.src.entity.ClothingItem;
import com.app.src.service.ClothingItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClothingItemController.class)
class ClothingItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ClothingItemService clothingItemService;

    private ClothingItem sampleItem;
    private ClothingItemRequestDTO sampleRequest;

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

        sampleRequest = new ClothingItemRequestDTO();
        sampleRequest.setName("Classic White Tee");
        sampleRequest.setCategory("Tops");
        sampleRequest.setSize("M");
        sampleRequest.setColor("White");
        sampleRequest.setPrice(350.00);
        sampleRequest.setImageUrl("https://example.com/tee.jpg");
        sampleRequest.setNotes("100% cotton");
    }

    @Test
    void testCreateClothingItem_Returns201() throws Exception {
        when(clothingItemService.createClothingItem(any(ClothingItem.class))).thenReturn(sampleItem);
        mockMvc.perform(post("/api/clothing-items")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Classic White Tee"))
                .andExpect(jsonPath("$.category").value("Tops"));
    }

    @Test
    void testGetAllClothingItems_Returns200() throws Exception {
        when(clothingItemService.getAllClothingItems()).thenReturn(List.of(sampleItem));
        mockMvc.perform(get("/api/clothing-items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Classic White Tee"));
    }

    @Test
    void testGetClothingItem_ExistingId_Returns200() throws Exception {
        when(clothingItemService.getClothingItem(1L)).thenReturn(sampleItem);
        mockMvc.perform(get("/api/clothing-items/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Classic White Tee"));
    }

    @Test
    void testGetClothingItem_NonExistingId_Returns404() throws Exception {
        when(clothingItemService.getClothingItem(99L))
                .thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing item not found with id: 99"));
        mockMvc.perform(get("/api/clothing-items/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateClothingItem_ValidId_Returns200() throws Exception {
        when(clothingItemService.updateClothingItem(eq(1L), any(ClothingItem.class))).thenReturn(sampleItem);
        mockMvc.perform(put("/api/clothing-items/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(sampleRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Classic White Tee"));
    }

    @Test
    void testDeleteClothingItem_ValidId_Returns204() throws Exception {
        doNothing().when(clothingItemService).deleteClothingItem(1L);
        mockMvc.perform(delete("/api/clothing-items/1"))
                .andExpect(status().isNoContent());
        verify(clothingItemService, times(1)).deleteClothingItem(1L);
    }

    @Test
    void testFilterItems_ValidParams_Returns200() throws Exception {
        when(clothingItemService.filterItems("Tops", "M", "White")).thenReturn(List.of(sampleItem));
        mockMvc.perform(get("/api/clothing-items/filter")
                        .param("category", "Tops")
                        .param("size", "M")
                        .param("color", "White"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].category").value("Tops"));
    }

    @Test
    void testGetAffordableItems_WithinBudget_Returns200() throws Exception {
        when(clothingItemService.getAffordableItems(500.00)).thenReturn(List.of(sampleItem));
        mockMvc.perform(get("/api/clothing-items/affordable")
                        .param("budget", "500.00"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].price").value(350.00));
    }
}