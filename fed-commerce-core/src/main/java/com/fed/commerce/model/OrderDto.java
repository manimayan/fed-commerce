package com.fed.commerce.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link Order} entity
 */
@Data
public class OrderDto implements Serializable {
    private String userId;
    private List<Product> product;

    public boolean checkOrder(OrderDto orderInputData) {
       return orderInputData.getProduct()!=null && orderInputData.getUserId()!=null;
    }
}