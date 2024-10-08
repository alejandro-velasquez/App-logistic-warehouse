package com.logistic_warehouse.infrastructure.controller.generic;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReadAll <T> {
    ResponseEntity<List<T>> readAll();
}
