package com.example.foundnlost.data.network.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Resource<T> {

    private int status;
    private String message;
    private T result;

    public Resource(int status, String message, T result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }


}

