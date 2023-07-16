package com.app.ecommerce.admin.product.mapper;

import com.app.ecommerce.admin.product.controller.dto.AdminProductDto;
import com.app.ecommerce.admin.product.model.AdminProduct;

public class AdminProductMapper {

    public static AdminProduct mapAdminProduct(Long id, AdminProductDto adminProductDto) {
        return AdminProduct.builder()
                .id(id)
                .name(adminProductDto.getName())
                .description(adminProductDto.getDescription())
                .category(adminProductDto.getCategory())
                .price(adminProductDto.getPrice())
                .currency(adminProductDto.getCurrency())
                .image(adminProductDto.getImage())
                .build();
    }
}
