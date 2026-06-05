package com.tismo.productsapp.controller;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.entity.ProductItem;
import com.tismo.productsapp.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// GRASP: Controller - Handles HTTP requests and delegates logic to service layer
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return service.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product updated) {
        return service.updateProduct(id, updated);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @PostMapping("/{id}/items")
    public Product addItem(@PathVariable Long id, @RequestBody ProductItem item) {
        return service.addItemToProduct(id, item);
    }
}