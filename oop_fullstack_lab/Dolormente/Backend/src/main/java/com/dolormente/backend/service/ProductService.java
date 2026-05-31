package com.dolormente.backend.service;

import com.dolormente.backend.entity.Product;
import com.dolormente.backend.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product add(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product updated) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(updated.getName());
        product.setPrice(updated.getPrice());
        product.setQuantity(updated.getQuantity());
        return repository.save(product);
    }

    @PostConstruct
    public void init() {
        repository.save(new Product(null, "Keyboard", 1000, 5));
        repository.save(new Product(null, "Mouse", 500, 10));
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
