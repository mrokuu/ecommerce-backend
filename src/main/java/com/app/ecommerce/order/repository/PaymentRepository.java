package com.app.ecommerce.order.repository;

import com.app.ecommerce.order.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
