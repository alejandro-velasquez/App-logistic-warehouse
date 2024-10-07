package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.LoginRequestDTO;
import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.domain.imodel.IModelAuth;
import com.logistic_warehouse.utils.enu.Role;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements com.logistic_warehouse.infrastructure.controller.interfaces.AuthController {

    @Autowired
    IModelAuth authService;
    @PostMapping("/register-admin")
    @Override
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO, Role.ADMIN));
    }

    @PostMapping("/register-carrier")
    @Override
    public ResponseEntity<?> registerCarrier(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,Role.CARRIER));

    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
    }
}
