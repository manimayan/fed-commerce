package com.fed.commerce.repository;


import com.fed.commerce.model.Cart;

import java.util.List;


public interface CartRepository {

    Cart getCartData(Cart cartData);

    void updateCart(Cart cartData);

    void saveCart(Cart cartData);

    List<Cart> getAllCartEntries();

    List<Cart> getUserCart(String userId);

    void deleteUserCart(String userId);

    void deleteProdCart(String userId, int prodId);
}
