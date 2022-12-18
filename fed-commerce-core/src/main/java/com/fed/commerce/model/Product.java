package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@DynamicUpdate
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = -3888600049566614744L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private int sku;

    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;

    @Size(max = 45)
    @Column(name = "description", length = 45)
    private String description;

    @Size(max = 45)
    @Column(name = "category", length = 45)
    private String category;

    @Size(max = 45)
    @Column(name = "price", length = 45)
    private String price;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @ToString.Exclude
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    @ToString.Exclude
    private Set<Cart> carts = new LinkedHashSet<>();

    public Product(int productId) {
        this.sku = productId;
    }

    public Product(ProductDto prodInputData) {
        this.sku = prodInputData.getSku();
        this.name = prodInputData.getName();
        this.category = prodInputData.getCategory();
        this.price = prodInputData.getPrice();
        this.quantity = prodInputData.getQuantity();
    }

    public void updateProductInputData(Product output, Product prodData) {
        this.sku = prodData.getSku();
        this.name = output.getName();
        this.category = output.getCategory();
        this.price = output.getPrice();
        this.quantity = prodData.getQuantity();
    }

    public void updateOrderProducts(Product foundOrder, Product product) {
        this.sku = product.getSku();
        this.name = foundOrder.getName();
        this.category = foundOrder.getCategory();
        this.price = foundOrder.getPrice();
        this.quantity = foundOrder.getQuantity()-product.getQuantity();
    }
}