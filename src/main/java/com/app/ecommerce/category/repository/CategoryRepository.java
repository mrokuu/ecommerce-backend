package com.app.ecommerce.category.repository;

import com.app.ecommerce.common.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByName(String name);
}
