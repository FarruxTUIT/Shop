package com.example.shop.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> exception(BadRequest badRequest) {
        return ResponseEntity.badRequest().body(badRequest.getMessage());
    }
}
