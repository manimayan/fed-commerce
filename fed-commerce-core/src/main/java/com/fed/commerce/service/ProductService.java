package com.fed.commerce.service;

import com.fed.commerce.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    boolean updateProduct(Product prodData);
}
