package com.hft.product.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpStatusException {
    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
