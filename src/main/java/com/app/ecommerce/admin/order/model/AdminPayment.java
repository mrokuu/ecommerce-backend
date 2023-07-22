package com.app.ecommerce.admin.order.model;

import com.app.ecommerce.order.model.PaymentType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "payment")
@Getter
public class AdminPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PaymentType type;
    private boolean defaultPayment;
    private String note;
}
