package com.fed.commerce.service.impl;


import com.fed.commerce.model.Cart;
import com.fed.commerce.repository.CartRepository;
import com.fed.commerce.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository repository;

    @Override
    public boolean updateCart(Cart cartData) {

        Cart cart = repository.getCartData(cartData);
        if (cart != null) {
            cartData.updateCartInputData(cart);
            repository.updateCart(cartData);
            log.info("cart updated successfully for user {} and product {}", cartData.getUser().getUserId(), cartData.getProduct().getSku());
        } else {
            repository.saveCart(cartData);
            log.info("successfully added to cart for user {} and product {}", cartData.getUser().getUserId(), cartData.getProduct().getSku());
        }
        return true;
    }

    @Override
    public List<Cart> getAllCartEntries() {

        List<Cart> output = repository.getAllCartEntries();
        if (!CollectionUtils.isEmpty(output)) {
            log.info("cart details fetched successfully");
        } else {
            log.info("fetching failed");
        }
        return output;
    }

    @Override
    public List<Cart> getUserCart(String userId) {

        List<Cart> output = repository.getUserCart(userId);
        if (!CollectionUtils.isEmpty(output)) {
            log.info("cart details fetched successfully for user - {}", userId);
        } else {
            log.info("fetching cart failed");
        }
        return output;
    }

    @Override
    public boolean deleteUserCart(String userId) {
        repository.deleteUserCart(userId);
        log.info("cart deleted successfully for user - {} ", userId);
        return true;
    }

    @Override
    public List<Cart> deleteProdCart(String userId, int prodId) {
        repository.deleteProdCart(userId, prodId);
        List<Cart> output = repository.getUserCart(userId);
        if (!CollectionUtils.isEmpty(output)) {
            log.info("product {} deleted from cart user - {} ", prodId, userId);
        } else {
            log.info("fetching cart failed");
        }
        return output;
    }
}

