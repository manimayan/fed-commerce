package com.fed.commerce.model;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link Product} entity
 */
@Data
public class ProductDto implements Serializable {
    private int sku;
    @Size(max = 45)
    private String name;
    @Size(max = 45)
    private String description;
    @Size(max = 45)
    private String category;
    @Size(max = 45)
    private String price;
    private int quantity;


    public boolean checkProduct() {
        return StringUtils.hasText(this.getName()) || StringUtils.hasText(this.getCategory())
                || StringUtils.hasText(this.getPrice()) || this.getQuantity() > 0;

    }
}