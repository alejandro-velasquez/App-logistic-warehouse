package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

public interface Delete<Entity,ID>{
    ResponseEntity<?> delete(ID id);
}
