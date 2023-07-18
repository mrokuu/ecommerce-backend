package com.app.ecommerce.category.dto;

import com.app.ecommerce.common.dto.ProductListDto;
import com.app.ecommerce.common.model.Category;
import com.app.ecommerce.common.model.Product;
import org.springframework.data.domain.Page;

public record CategoryProductsDto(Category category, Page<Product> products) {
}
