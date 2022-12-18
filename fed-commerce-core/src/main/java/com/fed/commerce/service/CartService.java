package com.fed.commerce.service;


import com.fed.commerce.model.Cart;

import java.util.List;

public interface CartService {
    boolean updateCart(Cart cartData);
    List<Cart> getAllCartEntries();

    List<Cart> getUserCart(String userId);

    boolean deleteUserCart(String userId);

    List<Cart> deleteProdCart(String userId, int prodId );
}
