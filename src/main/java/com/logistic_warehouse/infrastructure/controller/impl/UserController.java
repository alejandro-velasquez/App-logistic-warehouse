package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.service.impl.UserService;
import com.logistic_warehouse.infrastructure.controller.interfaces.IUserController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carrier")
public class UserController implements IUserController {

    @Autowired
    UserService userService;


    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> carrierLoadAssigned(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.readById(id));
    }
}
