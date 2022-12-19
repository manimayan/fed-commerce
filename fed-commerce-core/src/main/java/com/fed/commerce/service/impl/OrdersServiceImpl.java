package com.fed.commerce.service.impl;

import com.fed.commerce.model.Orders;
import com.fed.commerce.model.OrdersDto;
import com.fed.commerce.model.Product;
import com.fed.commerce.repository.CartRepository;
import com.fed.commerce.repository.OrdersRepository;
import com.fed.commerce.repository.ProductRepository;
import com.fed.commerce.service.OrdersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    OrdersRepository repository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

    @Override
    public Orders updateOrders(OrdersDto orderInputData) {

        Orders order = null;
        try {
            updateQuantity(orderInputData);
            deleteCart(orderInputData.getUserId());
            order = processOrder(orderInputData);
            log.info("order placed successfully for user {} and order_id is {} ", order.getUser().getUserId(), order.getOrdersBatch());

        } catch (Exception e) {
            // mail to support team
            log.info("problem in placing order for {}", orderInputData.getUserId());
        }
        return order;
    }

    private void updateQuantity(OrdersDto orderInputData) {
        List<Product> productList = orderInputData.getProduct();
        for (Product product : productList) {
            Product foundOrder = productRepository.getProductbyId(product.getSku());
            if (foundOrder != null) {
                foundOrder.updateOrdersProducts(foundOrder, product);
                productRepository.updateProd(foundOrder);
                log.info("product quantity updated for user order {} ", orderInputData.getUserId());
            }
        }
    }

    private void deleteCart(String userId) {
        cartRepository.deleteUserCart(userId);
        log.info("cart updated for user {} ", userId);
    }

    private Orders processOrder(OrdersDto orderInputData) {
        int recentOBatch = repository.getLastOrdersBatch() != null ? repository.getLastOrdersBatch().getOrdersBatch() : 0;
        Orders order = null;
        for (Product product : orderInputData.getProduct()) {
            order = new Orders(product, orderInputData, recentOBatch);
            order = repository.updateOrders(order);
        }
        return order;
    }

    @Override
    public List<Orders> getUserOrders(String userId) {

        List<Orders> output = repository.getUserOrders(userId);
        if (!CollectionUtils.isEmpty(output)) {
            log.info("order details fetched successfully for user - {}", userId);
        } else {
            log.info("fetching cart failed");
        }
        return output;
    }

    @Override
    public List<Orders> getAllOrdersEntry() {

        List<Orders> output = repository.getAllOrdersEntry();
        if (!CollectionUtils.isEmpty(output)) {
            log.info("cart details fetched successfully");
        } else {
            log.info("fetching failed");
        }
        return output;
    }
}
