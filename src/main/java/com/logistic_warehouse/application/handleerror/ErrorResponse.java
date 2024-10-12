package com.logistic_warehouse.application.handleerror;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ErrorResponse extends ErrorSimple {

    private String message;
}
