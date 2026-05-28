package com.casapao.app.service;

import com.casapao.app.entity.Product;
import com.casapao.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public Product getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Product create(Product product) {
        return repo.save(product);
    }

    public Product update(Long id, Product updated) {
        Product p = repo.findById(id).orElse(null);
        if (p == null) return null;

        p.setName(updated.getName());
        p.setDescription(updated.getDescription());
        p.setPrice(updated.getPrice());

        return repo.save(p);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}