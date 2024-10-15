package com.logistic_warehouse.infrastructure.controller.interfaces;

import org.springframework.http.ResponseEntity;

public interface IUserController {

    ResponseEntity<?> carrierLoadAssigned(Long id);
}
