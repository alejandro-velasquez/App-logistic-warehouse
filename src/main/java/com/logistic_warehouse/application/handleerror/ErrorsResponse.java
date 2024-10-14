package com.logistic_warehouse.application.handleerror;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.core.PriorityOrdered;

import java.util.List;

@Getter
@Setter
@SuperBuilder
public class ErrorsResponse extends ErrorSimple{

    private List<String> errors;
}
