package com.app.ecommerce.admin.order.model;

public enum AdminOrderStatus {
    NEW("New"),
    PAID("Paid"),
    PROCESSING("PROCESSING"),
    WAITING_FOR_DELIVERY("WAITING FOR DELIVERY"),
    COMPLETED("COMPLETED"),
    CANCELED("CANCELED"),
    REFUND("REFUND");

    private String value;

    AdminOrderStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

