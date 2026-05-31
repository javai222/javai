package com.dolormente.app.controller;

import com.dolormente.app.entity.ProductChip;
import com.dolormente.app.service.ProductChipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductChipController {

    @Autowired
    private ProductChipService service;

    @GetMapping
    public List<ProductChip> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProductChip getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProductChip create(@RequestBody ProductChip product) {
        return service.create(product);
    }

    @PutMapping("/{id}")
    public ProductChip update(@PathVariable Long id, @RequestBody ProductChip product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
