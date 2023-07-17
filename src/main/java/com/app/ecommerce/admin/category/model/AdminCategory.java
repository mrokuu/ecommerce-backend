package com.app.ecommerce.admin.category.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminCategory {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String url;
}
