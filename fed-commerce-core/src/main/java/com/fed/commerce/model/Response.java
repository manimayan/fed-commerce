package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Response implements Serializable {

    private boolean status;

    private String message;

    public void setResponse(String message, boolean status) {
        this.setMessage(message);
        this.setStatus(status);
    }
}
