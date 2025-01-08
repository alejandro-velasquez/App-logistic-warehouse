package com.logistic_warehouse.application.exeptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.logistic_warehouse.application.handleerror.ErrorSimple;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidFormat {

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorSimple handleInvalidFormat(InvalidFormatException e){
        return ErrorSimple.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(e.getMessage())
                .build();
    }
}

