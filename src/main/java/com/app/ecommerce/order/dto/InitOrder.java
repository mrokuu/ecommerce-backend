package com.app.ecommerce.order.dto;

import com.app.ecommerce.order.model.Payment;
import com.app.ecommerce.order.model.Shipment;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class InitOrder {
    private List<Shipment> shipment;
    private List<Payment> payment;
}
