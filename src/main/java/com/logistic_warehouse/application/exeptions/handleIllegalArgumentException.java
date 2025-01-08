package com.logistic_warehouse.application.exeptions;

import com.logistic_warehouse.application.handleerror.ErrorSimple;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class handleIllegalArgumentException {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorSimple handleIllegalArgumentException(IllegalArgumentException ex) {
        return ErrorSimple.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .message(ex.getMessage())
                .build();
    }
}
