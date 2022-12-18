package com.fed.commerce.controller;


import com.fed.commerce.model.Cart;
import com.fed.commerce.model.CartDto;
import com.fed.commerce.model.Response;
import com.fed.commerce.service.CartService;
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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateUser(@RequestBody CartDto cartInputData) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        boolean data;
        Response cartResponse = new Response();
        try {
            if (cartInputData.checkCart()) {

                Cart cartData = new Cart(cartInputData);

                data = service.updateCart(cartData);
                if (data) {
                    status = HttpStatus.OK;
                    cartResponse.setResponse("cart updated successfully", true);
                }
            } else {
                cartResponse.setResponse("cart inputs are missing", false);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in updating cart data for - {}", cartInputData.getUserId());
        }
        return new ResponseEntity<>(cartResponse, status);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getAllCartEntries() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<Cart> cartList = new ArrayList<>();
        try {
            cartList = service.getAllCartEntries();
            if (cartList != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in processing", e);
        }
        return new ResponseEntity<>(cartList, status);
    }

    @GetMapping(value = "/get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> getUserCart(@PathVariable String userId) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<Cart> userCartList = new ArrayList<>();
        try {
            userCartList = service.getUserCart(userId);
            if (userCartList != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in processing", e);
        }
        return new ResponseEntity<>(userCartList, status);
    }

    @DeleteMapping(value = "/delete/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteUserCart(@PathVariable String userId) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        boolean data;
        Response deleteCart = new Response();
        try {
            data = service.deleteUserCart(userId);
            if (data) {
                status = HttpStatus.OK;
                deleteCart.setResponse("cart deleted successfully", true);
            } else {
                deleteCart.setResponse("no items in cart to delete", false);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in deleting cart data for - {}", userId);
        }
        return new ResponseEntity<>(deleteCart, status);
    }

    @DeleteMapping(value = "/prod/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cart>> deleteUserCartProduct(@RequestParam String userId, @RequestParam int prodId) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        List<Cart> updatedCart = new ArrayList<>();
        try {
            updatedCart = service.deleteProdCart(userId, prodId);
            if (updatedCart != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in updating cart data for - {} and Product - {}", userId, prodId);
        }
        return new ResponseEntity<>(updatedCart, status);
    }

}
