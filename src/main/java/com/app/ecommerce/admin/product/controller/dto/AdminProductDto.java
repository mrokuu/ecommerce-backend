package com.app.ecommerce.admin.product.controller.dto;

import com.app.ecommerce.admin.product.model.AdminProductCurrency;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;


import java.math.BigDecimal;

@Getter
public class AdminProductDto {


    @NotBlank
    @Length(min = 4)
    private String name;
    @NotBlank
    @Length(min = 4)
    private String category;
    @NotBlank
    @Length(min = 4)
    private String description;
    @NotNull
    @Min(0)
    private BigDecimal price;
    private AdminProductCurrency currency;
    private String image;
}
