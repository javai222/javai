package com.plantilla.app.service;

import com.plantilla.app.entity.Item;
import com.plantilla.app.exception.ResourceNotFoundException;
import com.plantilla.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Item existing = getItemById(id);
        existing.setItemName(updatedItem.getItemName());
        existing.setItemCode(updatedItem.getItemCode());
        existing.setQuantity(updatedItem.getQuantity());
        existing.setPrice(updatedItem.getPrice());
        existing.setIsAvailable(updatedItem.getIsAvailable());
        return itemRepository.save(existing);
    }

    public void deleteItem(Long id) {
        getItemById(id);
        itemRepository.deleteById(id);
    }
}