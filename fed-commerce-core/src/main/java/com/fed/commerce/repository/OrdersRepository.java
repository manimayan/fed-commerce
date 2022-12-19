package com.fed.commerce.repository;



import com.fed.commerce.model.Orders;

import java.util.List;

public interface OrdersRepository {


    Orders updateOrders(Orders orders);

    List<Orders> getUserOrders(String userId);

    List<Orders> getAllOrdersEntry();

    Orders getLastOrdersBatch();
}
