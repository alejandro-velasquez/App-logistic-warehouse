package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

public interface ReadById <T, ID>{
    ResponseEntity<?> readById(ID id);
}
