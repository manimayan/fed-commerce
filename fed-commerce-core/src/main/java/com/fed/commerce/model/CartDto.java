package com.fed.commerce.model;

import lombok.Data;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * A DTO for the {@link Cart} entity
 */
@Data
public class CartDto implements Serializable {
    private String userId;
    private int quantity;
    private int productId;


    public boolean checkCart() {
        return StringUtils.hasText(this.getUserId()) || this.getProductId() > 0 || this.getQuantity() > 0;

    }
}