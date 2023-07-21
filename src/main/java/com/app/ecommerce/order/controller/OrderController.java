package com.app.ecommerce.order.controller;

import com.app.ecommerce.order.dto.InitOrder;
import com.app.ecommerce.order.dto.OrderDto;
import com.app.ecommerce.order.dto.OrderSummary;
import com.app.ecommerce.order.service.OrderService;
import com.app.ecommerce.order.service.PaymentService;
import com.app.ecommerce.order.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ShipmentService shipmentService;
    private final PaymentService paymentService;

    @PostMapping
    public OrderSummary placeOrder(@RequestBody OrderDto orderDto) {
        return orderService.placeOrder(orderDto);
    }

    @GetMapping("/initData")
    public InitOrder initData() {
        return InitOrder.builder()
                .shipment(shipmentService.getShipments())
                .payment(paymentService.getPayments())
                .build();
    }
}