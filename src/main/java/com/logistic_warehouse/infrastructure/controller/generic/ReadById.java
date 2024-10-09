package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

public interface ReadById <ID>{
    ResponseEntity<?> readById(ID id);
}
