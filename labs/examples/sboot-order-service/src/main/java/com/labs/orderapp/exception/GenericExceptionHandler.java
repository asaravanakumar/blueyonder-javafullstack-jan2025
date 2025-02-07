package com.labs.orderapp.exception;

import com.labs.orderapp.model.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseMessage> handleGenericException(Exception e) {
        return ResponseEntity
                .internalServerError()
                .body(ResponseMessage.builder().status("ERROR")
                        .message(e.getMessage()).build());
    }
}
