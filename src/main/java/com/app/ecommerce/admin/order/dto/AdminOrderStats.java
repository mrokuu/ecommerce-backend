package com.app.ecommerce.admin.order.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Builder
public class AdminOrderStats {
    private List<Integer> label;
    private List<BigDecimal> sale;
    private List<Long> order;
    private Long ordersCount;
    private BigDecimal salesSum;
}

