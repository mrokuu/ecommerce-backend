package com.app.ecommerce.category.controller;

import com.app.ecommerce.category.dto.CategoryProductsDto;
import com.app.ecommerce.category.service.CategoryService;
import com.app.ecommerce.common.model.Category;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Validated
public class CategoryController {

    public final CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/categories/{name}/products")
    public CategoryProductsDto getCategoriesWithProducts(@PathVariable String name, Pageable pageable) {

        return categoryService.getCategoriesWithProducts(name, pageable);
    }

}
