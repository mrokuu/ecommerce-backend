package com.app.ecommerce.admin.product.service;

import com.app.ecommerce.admin.product.controller.dto.AdminProductDto;
import com.app.ecommerce.admin.product.model.AdminProduct;
import com.app.ecommerce.admin.product.repository.AdminProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminProductService {

    private final AdminProductRepository adminProductRepository;


    public Page<AdminProduct> getProducts(Pageable pageable) {
        return adminProductRepository.findAll(pageable);
    }

    public AdminProduct getProduct(Long id) {
        return adminProductRepository.findById(id).orElseThrow();
    }


    public AdminProduct createProduct(AdminProduct adminProduct) {
        return adminProductRepository.save(adminProduct);
    }

    public AdminProduct updateProduct(AdminProduct product) {
        return adminProductRepository.save(product);
    }

    public void deleteProduct(Long id) {
        adminProductRepository.deleteById(id);
    }
}
