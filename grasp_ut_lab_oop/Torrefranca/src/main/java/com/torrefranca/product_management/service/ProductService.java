package com.torrefranca.product_management.service;

import com.torrefranca.product_management.dto.ProductDto;
import com.torrefranca.product_management.entity.Product;
import com.torrefranca.product_management.repository.ProductRepository;
import com.torrefranca.product_management.util.DiscountStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// GRASP: Pure Fabrication
// Service contains business logic and coordinates operations

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // GRASP: Low Coupling
    // Depends on repository abstraction rather than database details
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // GRASP: Creator
    // Service creates Product objects from DTO data
    public Product createProduct(ProductDto dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, ProductDto dto) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(dto.getName());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    // GRASP: Protected Variations + Polymorphism
    public double calculateDiscountedPrice(Long productId,
                                           DiscountStrategy strategy) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return strategy.applyDiscount(product.getPrice());
    }
}