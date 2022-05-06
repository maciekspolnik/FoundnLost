package com.example.foundnlost.data.network.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Response<T> {

    private int status;
    private String message;
    private Object result;

    public Response(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }


}

