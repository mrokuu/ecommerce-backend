package com.app.ecommerce.admin.order.repository;

import com.app.ecommerce.admin.order.model.AdminOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AdminOrderRepository extends JpaRepository<AdminOrder, Long> {
}

