package com.fed.commerce.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Orders} entity
 */
@Data
public class OrdersDto implements Serializable {
    private String userId;
    private List<Product> product;

    public boolean checkOrders(OrdersDto OrdersInputData) {
       return OrdersInputData.getProduct()!=null && OrdersInputData.getUserId()!=null;
    }
}