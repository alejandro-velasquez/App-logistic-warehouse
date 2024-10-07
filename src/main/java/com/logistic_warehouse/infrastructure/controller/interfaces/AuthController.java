package com.logistic_warehouse.infrastructure.controller.interfaces;

import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import org.springframework.http.ResponseEntity;

public interface AuthController {
    ResponseEntity<?> registerAdmin(RegisterRequestDTO registerRequestDTO);
    ResponseEntity<?> registerCarrier(RegisterRequestDTO registerRequestDTO);
}
