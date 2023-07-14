package com.app.ecommerce.product.service;

import com.app.ecommerce.product.model.Product;
import com.app.ecommerce.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
}
