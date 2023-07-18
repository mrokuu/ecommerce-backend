package com.app.ecommerce.category.service;

import com.app.ecommerce.category.dto.CategoryProductsDto;
import com.app.ecommerce.category.repository.CategoryRepository;
import com.app.ecommerce.common.model.Category;
import com.app.ecommerce.common.model.Product;
import com.app.ecommerce.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public CategoryProductsDto getCategoriesWithProducts(String name, Pageable pageable) {
        Category category =  categoryRepository.findByName(name);
        Page<Product> page  = productRepository.findByCategoryId(category.getId(), pageable);
        return new CategoryProductsDto(category,page);
    }
}
