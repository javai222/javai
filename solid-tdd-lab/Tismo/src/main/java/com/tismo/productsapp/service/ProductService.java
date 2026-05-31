package com.tismo.productsapp.service;

import com.tismo.productsapp.entity.Product;
import com.tismo.productsapp.entity.ProductItem;
import com.tismo.productsapp.exception.ProductNotFoundException;
import com.tismo.productsapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// GRASP: Pure Fabrication - Service layer contains business logic separate from entities/controllers
public class ProductService {

    private final ProductRepository repo;

    // GRASP: Low Coupling - Service depends on abstraction (repository layer)
    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    // GRASP: Pure Fabrication - Service handles product creation workflow
    public Product createProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // GRASP: Indirection - Repository handles database access
    public Product getProductById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // GRASP: High Cohesion - Method only handles updating product details
    public Product updateProduct(Long id, Product updated) {
        Product existing = getProductById(id);

        existing.setName(updated.getName());
        existing.setPrice(updated.getPrice());

        return repo.save(existing);
    }

    public void deleteProduct(Long id) {
        Product existing = getProductById(id);
        repo.delete(existing);
    }

    // GRASP: Information Expert - Product entity manages item creation internally
    public Product addItemToProduct(Long id, ProductItem item) {
        Product product = getProductById(id);

        product.addItem(item.getItemName(), item.getQuantity());

        return repo.save(product);
    }
}