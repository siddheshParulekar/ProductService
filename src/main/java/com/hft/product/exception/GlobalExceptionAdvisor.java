//package com.hft.product.exception;
//
//import com.hft.product.dto.ResponseDTO;
//import com.thrift.hft.constants.ErrorMsgConstants;
//import com.thrift.hft.dto.ResponseDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.nio.file.AccessDeniedException;
//import java.util.Objects;
//
//@ControllerAdvice
//@Slf4j
//public class GlobalExceptionAdvisor extends ResponseEntityExceptionHandle {
//
//    private static final Logger logger = LogManager.getLogger(GlobalExceptionAdvisor.class);
//
//
//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
//                                                                  HttpStatus status, WebRequest request) {
//
//        ResponseDTO<Object> responseDTO = new ResponseDTO();
//        responseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
//
//        if (Objects.nonNull(ex.getBindingResult().getGlobalError()))
//            responseDTO.setMessage(ex.getBindingResult().getGlobalError().getDefaultMessage());
//        else
//            responseDTO.setMessage(ex.getBindingResult().getFieldError().getDefaultMessage());
//
//        return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//    }
//
//
//}
