package com.cantela.fullstackApp.Service;

import com.cantela.fullstackApp.Entity.Product;
import com.cantela.fullstackApp.Exception.ResourceNotFoundException;
import com.cantela.fullstackApp.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public Product createProduct (Product product) {
            return productRepository.save(product);
    }

    public Product getProductById (Long id) {
        return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id) );
    }

    public Product updateProduct(Long id, Product newProduct) {
        Product existing = getProductById(id);
        Optional.ofNullable(newProduct.getName()).ifPresent(existing::setName);

        if (newProduct.getPrice() > 0) existing.setPrice(newProduct.getPrice());

        Optional.ofNullable(newProduct.getDescription())
                        .ifPresent(existing::setDescription);
        Optional.ofNullable(newProduct.getQuantity())
                        .ifPresent(existing::setQuantity);
        return productRepository.save(existing);
    }

    public void deleteProduct (Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

}
