package com.app.ecommerce.cart.controller;

import com.app.ecommerce.cart.service.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @DeleteMapping("/cartItems/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartItemService.delete(id);
    }

    @GetMapping("/cartItems/count/{cartId}")
    public Long countItemInCart(@PathVariable Long cartId) {
        return cartItemService.countItemInCart(cartId);
    }

}
