package com.app.ecommerce.admin.category.controller;

import com.app.ecommerce.admin.category.model.AdminCategory;
import com.app.ecommerce.admin.category.service.AdminCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

    @GetMapping("/admin/categories")
    public List<AdminCategory> getCategories() {
        return null;
    }


    @GetMapping("/admin/categories/{id}")
    public AdminCategory getCategory(@PathVariable Long id) {
        return null;
    }

    @PostMapping("/admin/categories")
    public AdminCategory createCategory () {
        return null;
    }


    @PutMapping("/admin/categories/{id}")
    public AdminCategory updateCategory(@PathVariable Long id){
        return null;
    }

    @DeleteMapping("/admin/categories/{id}")
    public void deleteCategory(){

    }
}
