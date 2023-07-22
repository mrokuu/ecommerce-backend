package com.app.ecommerce.admin.order.dto;

import com.app.ecommerce.admin.order.model.AdminOrderStatus;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
public class AdminOrderDto {
    private Long id;
    private LocalDateTime placeDate;
    private AdminOrderStatus orderStatus;
    private BigDecimal grossValue;
}
