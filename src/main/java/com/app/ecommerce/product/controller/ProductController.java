package com.app.ecommerce.product.controller;

import com.app.ecommerce.common.dto.ProductListDto;
import com.app.ecommerce.common.model.Product;
import com.app.ecommerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public Page<ProductListDto> getProducts(Pageable pageable){

        Page<Product> products = productService.getProducts(pageable);
        List<ProductListDto> productListDto = products.getContent().stream()
                .map(product -> ProductListDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .currency(product.getCurrency())
                        .image(product.getImage())
                        .build()
                ).toList();
        return new PageImpl<>(productListDto, pageable, products.getTotalElements());
    }


    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }
}
