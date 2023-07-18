package com.app.ecommerce.product.controller;

import com.app.ecommerce.common.model.Product;
import com.app.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Page<Product> getProducts(Pageable pageable){

        return productService.getProducts(pageable);
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
}
