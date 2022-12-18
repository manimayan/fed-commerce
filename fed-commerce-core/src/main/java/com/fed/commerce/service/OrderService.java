package com.fed.commerce.service;

import com.fed.commerce.model.OrderDto;

public interface OrderService {
    boolean updateOrder(OrderDto orderInputData);
}
