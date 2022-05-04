package com.example.foundnlost.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.foundnlost.util.enums.Status;

import lombok.Getter;

public class Response<T> {

    @Getter
    private final Status status;

    @Nullable
    @Getter
    private final Throwable error;

    @Nullable
    @Getter
    private final T data;

    public Response(Status status, @Nullable T data, @Nullable Throwable error) {
        this.status = status;
        this.error = error;
        this.data = data;
    }

    public static <T> Response<T> success(@NonNull T data) {
        return new Response<>(Status.SUCCESS, data, null);
    }

    public static <T> Response<T> loading() {
        return new Response<>(Status.LOADING, null, null);
    }

    public static <T> Response<T> error(@NonNull Throwable error) {
        return new Response<>(Status.ERROR, null, error);
    }

    public static <T> Response<T> no_network() {
        return new Response<>(Status.NO_NETWORK, null, null);
    }

}
