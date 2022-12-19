package com.fed.commerce.controller;


import com.fed.commerce.model.Orders;
import com.fed.commerce.model.OrdersDto;
import com.fed.commerce.model.OrdersResponse;
import com.fed.commerce.model.Response;
import com.fed.commerce.service.OrdersService;
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
@RequestMapping("/orders")

public class OrdersController {

    @Autowired
    OrdersService service;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrdersResponse> ordersUpdate(@RequestBody OrdersDto ordersInputData) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Orders orders;
        OrdersResponse ordersResponse = new OrdersResponse();
        try {
            if (ordersInputData.checkOrders(ordersInputData)) {
                orders = service.updateOrders(ordersInputData);
                if (orders!=null) {
                    status = HttpStatus.OK;
                    ordersResponse.setResponse("Orders placed successfully", true, orders.getOrdersBatch());

                }
            } else {
                ordersResponse.setResponse("Orders not placed", false);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in updating Orders for - {}", ordersInputData.getUserId());
        }
        return new ResponseEntity<>(ordersResponse, status);
    }

    @GetMapping(value = "/get/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Orders>> getUserCart(@PathVariable String userId) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<Orders> userOrdersList = new ArrayList<>();
        try {
            userOrdersList = service.getUserOrders(userId);
            if (userOrdersList != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in processing", e);
        }
        return new ResponseEntity<>(userOrdersList, status);
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Orders>> getAllCartEntries() {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        List<Orders> ordersList = new ArrayList<>();
        try {
            ordersList = service.getAllOrdersEntry();
            if (ordersList != null) {
                status = HttpStatus.OK;
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in processing", e);
        }
        return new ResponseEntity<>(ordersList, status);
    }

}
