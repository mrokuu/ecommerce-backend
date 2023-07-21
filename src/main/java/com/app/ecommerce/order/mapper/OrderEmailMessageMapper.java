package com.app.ecommerce.order.mapper;

import com.app.ecommerce.order.model.Order;

import java.time.format.DateTimeFormatter;

public class OrderEmailMessageMapper {
    public static String createEmailMessage(Order order) {
        return "Your order id: " + order.getId() +
                "\nDate of placing the order: " + order.getPlaceDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) +
                "\nValue: " + order.getGrossValue() + " PLN " +
                "\n\n" +
                "\nPayment: " + order.getPayment().getName() +
                (order.getPayment().getNote() != null ? "\n" + order.getPayment().getNote() : "") +
                "\n\nThank you for shopping.";
    }
}
