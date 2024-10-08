package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

public interface Update <ID,EntityRequest>{
    ResponseEntity<?> update(EntityRequest entityRequest,ID id);
}
