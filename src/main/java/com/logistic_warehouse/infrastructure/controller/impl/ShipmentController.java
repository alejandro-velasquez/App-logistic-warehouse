package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelShipment;
import com.logistic_warehouse.infrastructure.controller.interfaces.IShipmentController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Create a new Shipment",
            description = "This endpoint creates a new shipment record. The request body must include all required shipment details."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Shipment created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "409", description = "A shipment with the same identifier already exists.")
    })
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid ShipmentRequestDTO shipmentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shipmentService.create(shipmentRequestDTO));
    }

    @Override
    public ResponseEntity<?> delete(ShipmentEntity shipmentEntity) {
        return null;
    }

    @Operation(
            summary = "Retrieve all Shipments",
            description = "This endpoint retrieves all the shipment records from the database."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipments retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "No shipments found.")
    })
    @GetMapping("/read-all")
    @Override
    public ResponseEntity<List<ShipmentEntity>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.readAll());
    }

    @Operation(
            summary = "Retrieve a Shipment by ID",
            description = "Fetch a specific shipment by its unique ID."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shipment found and retrieved successfully."),
            @ApiResponse(responseCode = "404", description = "Shipment not found with the given ID.")
    })
    @GetMapping("/read/{id}")
    @Override
    public ResponseEntity<?> readById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.readById(id));
    }
}
