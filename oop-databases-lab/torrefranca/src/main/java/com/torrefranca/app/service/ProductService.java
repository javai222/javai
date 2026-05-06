package com.torrefranca.app.service;

import com.torrefranca.app.entity.Product;
import com.torrefranca.app.entity.User;
import com.torrefranca.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("User not Found!"));
    }

    public Product createProduct(Product Product) {
        return productRepository.save(Product);
    }

    public Product updateProduct(Long id, Product Product) {
        Product existing = getProduct(id);

        existing.setName(Product.getName());
        existing.setPrice(Product.getPrice());
        existing.setCategory(Product.getCategory());
        existing.setDescription(Product.getDescription());
        existing.setQuantity(Product.getQuantity());
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        getProduct(id);
        productRepository.deleteById(id);
    }
}
