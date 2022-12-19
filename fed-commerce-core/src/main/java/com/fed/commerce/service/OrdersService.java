package com.fed.commerce.service;


import com.fed.commerce.model.Orders;
import com.fed.commerce.model.OrdersDto;

import java.util.List;

public interface OrdersService {
    Orders updateOrders(OrdersDto orderInputData);

    List<Orders> getUserOrders(String userId);

    List<Orders> getAllOrdersEntry();
}
