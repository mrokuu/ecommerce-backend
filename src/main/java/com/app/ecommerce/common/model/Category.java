package com.app.ecommerce.common.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @OneToMany
//    @JoinColumn(name = "categoryId")
//    private List<Product> product;
}
