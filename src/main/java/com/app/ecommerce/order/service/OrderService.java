package com.app.ecommerce.order.service;

import com.app.ecommerce.cart.model.Cart;
import com.app.ecommerce.cart.repository.CartItemRepository;
import com.app.ecommerce.cart.repository.CartRepository;
//import com.app.ecommerce.common.email.EmailClientService;
import com.app.ecommerce.common.email.EmailSimpleService;
import com.app.ecommerce.order.dto.OrderDto;
import com.app.ecommerce.order.dto.OrderSummary;
import com.app.ecommerce.order.model.Order;
import com.app.ecommerce.order.model.Payment;
import com.app.ecommerce.order.model.Shipment;
import com.app.ecommerce.order.repository.OrderRepository;
import com.app.ecommerce.order.repository.OrderRowRepository;
import com.app.ecommerce.order.repository.PaymentRepository;
import com.app.ecommerce.order.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.app.ecommerce.order.mapper.OrderEmailMessageMapper.createEmailMessage;
import static com.app.ecommerce.order.mapper.OrderMapper.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRowRepository orderRowRepository;
    private final ShipmentRepository shipmentRepository;
    private final PaymentRepository paymentRepository;
//    private final EmailClientService emailClientService;
    private final EmailSimpleService emailSimpleService;

    @Transactional
    public OrderSummary placeOrder(OrderDto orderDto) {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow();
        Shipment shipment = shipmentRepository.findById(orderDto.getShipmentId()).orElseThrow();
        Payment payment = paymentRepository.findById(orderDto.getPaymentId()).orElseThrow();
        Order newOrder = orderRepository.save(createNewOrder(orderDto, cart, shipment, payment));
        saveOrderRows(cart, newOrder.getId(), shipment);
        clearOrderCart(orderDto);
//        sendConfirmEmail(newOrder);
        emailSimpleService.send(newOrder.getEmail(), "Your order has been placed", createEmailMessage(newOrder));
        return createOrderSummary(payment, newOrder);
    }

//    private void sendConfirmEmail(Order newOrder) {
//        emailClientService.getInstance()
//                .send(newOrder.getEmail(),
//                        "Your order has been accepted",
//                        createEmailMessage(newOrder));
//    }

    private void clearOrderCart(OrderDto orderDto) {
        cartItemRepository.deleteByCartId(orderDto.getCartId());
        cartRepository.deleteCartById(orderDto.getCartId());
    }

    private void saveOrderRows(Cart cart, Long orderId, Shipment shipment) {
        saveProductRows(cart, orderId);
        saveShipmentRow(orderId, shipment);
    }

    private void saveShipmentRow(Long orderId, Shipment shipment) {
        orderRowRepository.save(mapToOrderRow(orderId, shipment));
    }

    private void saveProductRows(Cart cart, Long orderId) {
        cart.getItems().stream()
                .map(cartItem -> mapToOrderRowWithQuantity(orderId, cartItem)
                )
                .peek(orderRowRepository::save)
                .toList();
    }
}

