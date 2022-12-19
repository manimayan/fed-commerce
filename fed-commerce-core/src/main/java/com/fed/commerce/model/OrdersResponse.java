package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrdersResponse implements Serializable {

    private boolean status;

    private String message;

    @JsonProperty("order_id")
    private int orderId;

    public void setResponse(String message, boolean status, int ordersBatch) {
        this.setMessage(message);
        this.setStatus(status);
        this.orderId = ordersBatch;
    }

    public void setResponse(String message, boolean status) {
        this.setMessage(message);
        this.setStatus(status);

    }
}
