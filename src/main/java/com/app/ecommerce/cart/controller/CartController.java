package com.app.ecommerce.cart.controller;

import com.app.ecommerce.cart.controller.dto.CartProductDto;
import com.app.ecommerce.cart.controller.dto.CartSummaryDto;
import com.app.ecommerce.cart.mapper.CartMapper;
import com.app.ecommerce.cart.model.Cart;
import com.app.ecommerce.cart.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    @GetMapping("/carts/{id}")
    public Cart getCart(@PathVariable  Long id){
        return cartService.getCart(id);
    }


    @PutMapping("/carts/{id}")
    public Cart addProductToCart(@PathVariable  Long id, @RequestBody CartProductDto cartProductDto){
        return cartService.addProductToCart(id, cartProductDto);
    }


    @PutMapping("/carts/{id}/update")
    public CartSummaryDto updateCart(@PathVariable Long id, @RequestBody List<CartProductDto> cartProductDtos){
        return CartMapper.mapToCartSummary(cartService.updateCart(id, cartProductDtos));
    }
}
