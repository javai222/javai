package com.mance.app.controller;

import com.mance.app.entity.Product;
import com.mance.app.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getPlayer(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PostMapping
    public ResponseEntity<Product> createPlayer(@Valid @RequestBody Product player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updatePlayer(@PathVariable Long id, @Valid @RequestBody Product player) {
        return ResponseEntity.ok(productService.updateProduct(id, player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build(); //204 error
    }
}
