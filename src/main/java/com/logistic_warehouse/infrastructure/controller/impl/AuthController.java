package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.domain.imodel.IModelAuth;
import com.logistic_warehouse.utils.enu.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements com.logistic_warehouse.infrastructure.controller.interfaces.AuthController {

    @Autowired
    IModelAuth authService;
    @PostMapping("/register-admin")
    @Override
    public ResponseEntity<?> registerAdmin(RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO, Role.ADMIN));
    }

    @Override
    public ResponseEntity<?> registerCarrier(RegisterRequestDTO registerRequestDTO) {

        return null;
    }
}
