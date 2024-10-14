package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.ShipmentAssignCarrierRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentPatchRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelShipment;
import com.logistic_warehouse.infrastructure.controller.interfaces.IShipmentController;
import com.logistic_warehouse.utils.enu.ShipmentStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
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
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(shipmentService.create(shipmentRequestDTO));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
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


    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid ShipmentUpdateRequestDTO shipmentUpdateRequestDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(shipmentService.update(shipmentUpdateRequestDTO, id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PatchMapping("/update-status/{id}")
    @Override
    public ResponseEntity<?> updateStatus(@RequestBody ShipmentStatus status, @PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.updateStatus(status, id));
    }

    @PatchMapping("/assign-carrier/{id}")
    @Override
    public ResponseEntity<?> AssignCarrier(@RequestBody @Valid ShipmentAssignCarrierRequestDTO shipmentAssignCarrierRequestDTO,@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(shipmentService.assignCarrier(shipmentAssignCarrierRequestDTO,id));
    }
}
