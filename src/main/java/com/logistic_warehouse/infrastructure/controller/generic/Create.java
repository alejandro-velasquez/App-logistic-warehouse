package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

public interface Create <Entity>{
    ResponseEntity<?> create(Entity entity);
}
