package com.app.ecommerce.product.service;

import com.app.ecommerce.common.model.Product;
import com.app.ecommerce.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public Page<Product> getProducts(Pageable pageable){
        return productRepository.findAll(pageable);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow();
    }
}
