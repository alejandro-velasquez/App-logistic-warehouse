package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.LoginRequestDTO;
import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.domain.imodel.IModelAuth;
import com.logistic_warehouse.utils.enu.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "register users",description = "register admin and carrier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "user register successful"),
            @ApiResponse(responseCode = "404",description = "user not found")
    })
    @PostMapping("/register-admin")
    @Override
    public ResponseEntity<?> registerAdmin(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO, Role.ADMIN));
    }

    @Operation(
            summary = "Register Carrier User",
            description = "Registers a new user as a Carrier. The request body must include the necessary user details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully as Carrier."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "409", description = "User with the same email already exists.")
    })
    @PostMapping("/register-carrier")
    @Override
    public ResponseEntity<?> registerCarrier(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(registerRequestDTO,Role.CARRIER));

    }

    @Operation(
            summary = "Login",
            description = "Logs in a user with valid credentials. The request body must include the email and password."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Login successful."),
            @ApiResponse(responseCode = "400", description = "Invalid credentials provided."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @PostMapping("/login")
    @Override
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(authService.login(loginRequestDTO));
    }
}
