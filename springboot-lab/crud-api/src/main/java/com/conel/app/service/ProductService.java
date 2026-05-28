package com.conel.app.service;

import com.conel.app.dto.ProductDTO;
import com.conel.app.entity.Product;
import com.conel.app.exception.ResourceNotFoundException;
import com.conel.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ProductDTO getProductById(Long id) {
        return mapToDTO(productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id)));
    }

    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategory(category).stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO dto) {
        return mapToDTO(productRepository.save(mapToEntity(dto)));
    }

    public ProductDTO updateProduct(Long id, ProductDTO dto) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", id));
        if (dto.getName() != null)        existing.setName(dto.getName());
        if (dto.getDescription() != null) existing.setDescription(dto.getDescription());
        if (dto.getPrice() != null)       existing.setPrice(dto.getPrice());
        if (dto.getStock() != null)       existing.setStock(dto.getStock());
        if (dto.getCategory() != null)    existing.setCategory(dto.getCategory());
        return mapToDTO(productRepository.save(existing));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product", id);
        }
        productRepository.deleteById(id);
    }

    private ProductDTO mapToDTO(Product p) {
        return ProductDTO.builder()
                .id(p.getId()).name(p.getName()).description(p.getDescription())
                .price(p.getPrice()).stock(p.getStock()).category(p.getCategory()).build();
    }

    private Product mapToEntity(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName()).description(dto.getDescription())
                .price(dto.getPrice()).stock(dto.getStock()).category(dto.getCategory()).build();
    }
}