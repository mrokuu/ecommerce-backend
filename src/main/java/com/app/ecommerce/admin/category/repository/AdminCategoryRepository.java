package com.app.ecommerce.admin.category.repository;

import com.app.ecommerce.admin.category.model.AdminCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminCategoryRepository extends JpaRepository<AdminCategory, Long> {
}
