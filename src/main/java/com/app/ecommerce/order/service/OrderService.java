package com.app.ecommerce.order.service;

import com.app.ecommerce.cart.repository.CartItemRepository;
import com.app.ecommerce.cart.repository.CartRepository;
import com.app.ecommerce.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderRowRepository orderRowRepository;
    private final ShipmentRepository shipmentRepository;
    private final PaymentRepository paymentRepository;
    private final EmailClientService emailClientService;

    @Transactional
    public OrderSummary placeOrder(OrderDto orderDto) {
        Cart cart = cartRepository.findById(orderDto.getCartId()).orElseThrow();
        Shipment shipment = shipmentRepository.findById(orderDto.getShipmentId()).orElseThrow();
        Payment payment = paymentRepository.findById(orderDto.getPaymentId()).orElseThrow();
        Order newOrder = orderRepository.save(createNewOrder(orderDto, cart, shipment, payment));
        saveOrderRows(cart, newOrder.getId(), shipment);
        clearOrderCart(orderDto);
        sendConfirmEmail(newOrder);
        return createOrderSummary(payment, newOrder);
    }

    private void sendConfirmEmail(Order newOrder) {
        emailClientService.getInstance()
                .send(newOrder.getEmail(),
                        "Twoje zamówienie zostało przyjęte",
                        createEmailMessage(newOrder));
    }

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

