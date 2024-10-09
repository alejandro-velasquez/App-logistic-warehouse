package com.logistic_warehouse.application.service.generic;

import org.springframework.http.ResponseEntity;

public interface Update <ID,Entity,EntityRequest> {
    Entity update(EntityRequest entityRequest, ID id);
}