package com.hft.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@Data
public class ResponseDTO<T> {

    private int status = HttpStatus.OK.value();
    private T data;
    private String message = "SUCCESS";

    public ResponseDTO(T data, String message) {
        this.data = data;
        this.message = message;
    }
}
