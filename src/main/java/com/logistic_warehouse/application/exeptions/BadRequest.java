package com.logistic_warehouse.application.exeptions;

import com.logistic_warehouse.application.handleerror.ErrorSimple;
import com.logistic_warehouse.application.handleerror.ErrorsResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequest {

    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
    public ErrorsResponse badRequest(Exception exception){

        List<String> errors = new ArrayList<>();

        if(exception instanceof MethodArgumentNotValidException e){
            e.getAllErrors().forEach(error-> errors.add(error.getDefaultMessage()));
        } else if (exception instanceof ConstraintViolationException e) {
            e.getConstraintViolations().forEach(violation -> errors.add(violation.getMessage()));
        }else {
            errors.add(exception.getMessage());
        }

        return ErrorsResponse.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .status(HttpStatus.BAD_REQUEST.name())
                .errors(errors)
                .build();
    }
}
