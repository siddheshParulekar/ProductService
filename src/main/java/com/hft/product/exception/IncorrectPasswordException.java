package com.hft.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Please enter correct Password")
public class IncorrectPasswordException extends RuntimeException{
}
