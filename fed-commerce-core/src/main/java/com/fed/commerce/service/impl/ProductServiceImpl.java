package com.fed.commerce.service.impl;

import com.fed.commerce.model.Product;
import com.fed.commerce.repository.ProductRepository;
import com.fed.commerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> getAllProducts() {

        List<Product> output = repository.getAllProducts();
        if (!CollectionUtils.isEmpty(output)) {
            log.info("product details fetched successfully");
        } else {
            log.info("fetching failed");
        }
        return output;
    }

    @Override
    public boolean updateProduct(Product prodData) {
        boolean data = false;
        if (prodData.getSku() > 0) {
            Product output = repository.getProductbyId(prodData.getSku());
            if (output != null) {
                prodData.updateProductInputData(output, prodData);
                repository.updateProd(prodData);
                log.info("product updated successfully - {} -  {}", prodData.getSku(), prodData.getName());
                data = true;
            } else {
                log.info("no product found to update");
            }
        } else {
            repository.saveProduct(prodData);
            log.info("product added successfully - {}", prodData.getName());
            data = true;
        }
        return data;
    }
}
