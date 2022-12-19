package com.fed.commerce.controller;


import com.fed.commerce.model.Product;
import com.fed.commerce.model.ProductDto;
import com.fed.commerce.model.Response;
import com.fed.commerce.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateProduct(@RequestBody ProductDto prodInputData) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        boolean data;
        Response cartResponse = new Response();
        try {
            if (prodInputData.checkProduct()) {

                Product prodData = new Product(prodInputData);
                data = service.updateProduct(prodData);
                if (data) {
                    status = HttpStatus.OK;
                    cartResponse.setResponse("product updated successfully", true);
                } else {
                    cartResponse.setResponse("no product found to update", false);
                }
            } else {
                cartResponse.setResponse("incomplete product data", false);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in updating product data for - {}", prodInputData.getName());
        }
        return new ResponseEntity<>(cartResponse, status);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<Product> productsList = new ArrayList<>();
        try {
            productsList = service.getAllProducts();
            if (productsList != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in processing", e);
        }
        return new ResponseEntity<>(productsList, status);
    }
}
