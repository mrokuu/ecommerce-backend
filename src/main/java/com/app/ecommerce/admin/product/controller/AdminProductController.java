package com.app.ecommerce.admin.product.controller;

import com.app.ecommerce.admin.product.controller.dto.AdminProductDto;
import com.app.ecommerce.admin.product.model.AdminProduct;
import com.app.ecommerce.admin.product.service.AdminProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import static com.app.ecommerce.admin.product.mapper.AdminProductMapper.mapAdminProduct;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    public static final Long EMPTY_ID = null;
    private final AdminProductService adminProductService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductService.getProducts(pageable);
    }


    @GetMapping("/admin/products/{id}")
    public AdminProduct getProduct(@PathVariable Long id){
    return adminProductService.getProduct(id);
    }


    @PostMapping("/admin/products")
    public AdminProduct createProduct(@RequestBody AdminProductDto adminProductDto){
        return adminProductService.createProduct(mapAdminProduct(EMPTY_ID, adminProductDto)
        );
    }


    @PutMapping("/admin/products/{id}")
    public AdminProduct updateProduct(@PathVariable Long id, @RequestBody AdminProductDto adminProductDto ){
        return adminProductService.updateProduct(mapAdminProduct(id, adminProductDto)
        );
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        adminProductService.deleteProduct(id);
    }


}
