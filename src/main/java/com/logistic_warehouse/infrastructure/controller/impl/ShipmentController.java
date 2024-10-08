package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelShipment;
import com.logistic_warehouse.infrastructure.controller.interfaces.IShipmentController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loads")
public class ShipmentController implements IShipmentController {

    @Autowired
    IModelShipment shipmentService;


    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid ShipmentRequestDTO shipmentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shipmentService.create(shipmentRequestDTO));
    }

    @Override
    public ResponseEntity<?> delete(ShipmentEntity shipmentEntity) {
        return null;
    }

    @GetMapping("/read-all")
    @Override
    public ResponseEntity<List<ShipmentEntity>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.readAll());
    }

    @GetMapping("/read/{id}")
    @Override
    public ResponseEntity<?> readById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.readById(id));
    }
}
