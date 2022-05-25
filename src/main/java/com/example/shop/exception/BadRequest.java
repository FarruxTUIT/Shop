package com.example.shop.exception;

public class BadRequest extends RuntimeException {

    public BadRequest(String message) {
        super(message);
    }
}
