package com.javier.app.service;

import com.javier.app.entity.Product;
import com.javier.app.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() { return productRepository.findAll(); }

    public Product getById(Long id) { return productRepository.findById(id).orElseThrow(); }

    public Product create(Product product) { return productRepository.save(product); }

    public Product update(Long id, Product updated) {
        Product product = getById(id);
        product.setName(updated.getName());
        product.setDescription(updated.getDescription());
        product.setPrice(updated.getPrice());
        product.setStockQuantity(updated.getStockQuantity());
        product.setCategory(updated.getCategory());
        return productRepository.save(product);
    }

    public void delete(Long id) { productRepository.deleteById(id); }
}