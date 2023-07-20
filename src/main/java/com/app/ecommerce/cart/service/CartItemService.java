package com.app.ecommerce.cart.service;

import com.app.ecommerce.cart.repository.CartItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public void delete(Long id){
        cartItemRepository.deleteById(id);
    }

    public Long countItemInCart(Long cartId) {
        return cartItemRepository.countByCartId(cartId);
    }
}
