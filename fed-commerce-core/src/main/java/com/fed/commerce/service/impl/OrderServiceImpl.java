package com.fed.commerce.service.impl;

import com.fed.commerce.model.OrderDto;
import com.fed.commerce.model.Product;
import com.fed.commerce.repository.CartRepository;
import com.fed.commerce.repository.OrderRepository;
import com.fed.commerce.repository.ProductRepository;
import com.fed.commerce.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;


    @Override
    public boolean updateOrder(OrderDto orderInputData) {

        try {
            updateQuantity(orderInputData);
            deleteCart(orderInputData.getUserId());
            processOrder(orderInputData);
        } catch (Exception e) {

        }
//        if (cart != null) {
//        repository.updateOrder(orderInputData);
//            cartData.updateCartInputData(cart);
//            repository.updateCart(cartData);
//            log.info("cart updated successfully for user {} and product {}", cartData.getUser().getUserId(), cartData.getProduct().getSku());
//        } else {
//            repository.saveCart(cartData);
//            log.info("successfully added to cart for user {} and product {}", cartData.getUser().getUserId(), cartData.getProduct().getSku());
//        }
//        return true;
        return false;
    }

    private void updateQuantity(OrderDto orderInputData) {
        List<Product> productList = orderInputData.getProduct();
        for (Product product : productList) {
            Product foundOrder = productRepository.getProductbyId(product.getSku());
            if (foundOrder != null) {
                product.updateOrderProducts(foundOrder, product);
                productRepository.updateProd(product);
            }
        }
    }

    private void deleteCart(String userId) {
        cartRepository.deleteUserCart(userId);
    }

    private void processOrder(OrderDto orderInputData) {
    }
}
