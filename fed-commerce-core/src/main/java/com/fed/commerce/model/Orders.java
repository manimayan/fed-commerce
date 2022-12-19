package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    private static final long serialVersionUID = 3464460424785336190L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int ordersId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    @ToString.Exclude
    private Product product;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @UpdateTimestamp
    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "quantity")
    private int orderedQuantity;

    @Column(name = "order_batch")
    private int ordersBatch;

    public Orders(Product product, OrdersDto ordersInputData, int recentOBatch) {
        this.product = product;
        this.orderedQuantity = product.getQuantity();
        this.user = new User(ordersInputData.getUserId());
        this.ordersBatch = recentOBatch + 1;
    }
}