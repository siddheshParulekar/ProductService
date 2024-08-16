package com.hft.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidException extends HttpStatusException {
    public InvalidException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
