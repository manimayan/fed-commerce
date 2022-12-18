package com.fed.commerce.repository;


import com.fed.commerce.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    void saveProduct(Product prodData);

    void updateProd(Product prodData);

    Product getProductbyId(int prodId);
}
