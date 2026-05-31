package com.dolormente.app.service;

import com.dolormente.app.entity.ProductChip;
import com.dolormente.app.repository.ProductChipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductChipService {

    @Autowired
    private ProductChipRepository repository;

    public List<ProductChip> getAll() {
        return repository.findAll();
    }

    public ProductChip getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public ProductChip create(ProductChip product) {
        return repository.save(product);
    }

    public ProductChip update(Long id, ProductChip updated) {
        ProductChip product = getById(id);
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setType(updated.getType());
        product.setAvailable(updated.isAvailable());
        return repository.save(product);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
