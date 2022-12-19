package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

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
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 7856507339542951665L;
    @Id
    @Size(max = 45)
    @Column(name = "user_id", nullable = false, length = 45)
    private String userId;

    @Size(max = 45)
    @Column(name = "name", length = 45)
    private String name;

    @Size(max = 45)
    @Column(name = "password", length = 45)
    private String password;

    @Size(max = 45)
    @Column(name = "city", length = 45)
    private String city;

    @Size(max = 45)
    @Column(name = "postal_code", length = 45)
    private String postalCode;

    @Size(max = 45)
    @Column(name = "street", length = 45)
    private String street;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private Set<Orders> Orderss = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    @ToString.Exclude
    private Set<Cart> carts = new LinkedHashSet<>();

    public User(UserDto input) {
        this.userId = input.getUserId();
        this.password = input.getPassword();
    }

    public User(String userId) {
        this.userId=userId;
    }
}