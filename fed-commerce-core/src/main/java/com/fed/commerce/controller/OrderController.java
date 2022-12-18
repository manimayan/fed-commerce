package com.fed.commerce.controller;


import com.fed.commerce.model.Cart;
import com.fed.commerce.model.Order;
import com.fed.commerce.model.OrderDto;
import com.fed.commerce.model.Response;
import com.fed.commerce.service.CartService;
import com.fed.commerce.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/order")

public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> orderUpdate(@RequestBody OrderDto orderInputData) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        boolean order;
        Response orderResponse = new Response();
        try {
            if (orderInputData.checkOrder(orderInputData)) {
                order = service.updateOrder(orderInputData);
                if (order) {
                    status = HttpStatus.OK;
                    orderResponse.setResponse("order placed successfully", true);
                }
            } else {
                orderResponse.setResponse("order not placed", false);
            }
        } catch (Exception e) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            log.error("Error in updating order for - {}", orderInputData.getUserId());
        }
        return new ResponseEntity<>(orderResponse, status);
    }
}
