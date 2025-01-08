package com.logistic_warehouse.application.exeptions;

import com.logistic_warehouse.application.handleerror.ErrorsResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class BadRequest {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ErrorsResponse handleInvalidJson(HttpMessageNotReadableException exception) {
        String errorMessage = "Formato invalido";
        return buildErrorResponse(HttpStatus.BAD_REQUEST, List.of(errorMessage));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorsResponse handleValidationErrors(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorsResponse handleConstraintViolations(ConstraintViolationException exception) {
        List<String> errors = exception.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, errors);
    }



    // Helper method to build a unified error response
    private ErrorsResponse buildErrorResponse(HttpStatus status, List<String> errors) {
        return ErrorsResponse.builder()
                .code(status.value())
                .status(status.getReasonPhrase())
                .errors(errors)
                .build();
    }
}
