package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseReadAllDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.controller.interfaces.IPalletController;
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
@RequestMapping("/api/pallets")
public class PalletController implements IPalletController {

    @Autowired
    IModelPallet palletService;

    @Operation(
            summary = "Create a new Pallet",
            description = "This endpoint creates a new pallet with the provided details. The request body should include all necessary information for pallet creation."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pallet created successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "409", description = "A pallet with the same identifier already exists.")
    })
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(palletService.create(palletRequestCreateDTO));
    }

    @Operation(
            summary = "Delete a Pallet by ID",
            description = "Deletes a pallet based on its unique ID. If the pallet does not exist, a 'not found' error will be returned."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Pallet not found with the given ID.")
    })
    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(palletService.delete(id));
    }



    @Operation(
            summary = "Update an existing Pallet",
            description = "Updates the details of an existing pallet. The request body should contain the new information, and the ID should correspond to the pallet being updated."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet updated successfully."),
            @ApiResponse(responseCode = "400", description = "Invalid request body."),
            @ApiResponse(responseCode = "404", description = "Pallet not found with the given ID.")
    })
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(palletService.update(palletRequestCreateDTO, id));
    }

    @Override
    public ResponseEntity<?> delete(PalletEntity palletEntity) {
        return null;
    }


    @GetMapping("/read-all")
    @Override
    public ResponseEntity<List<PalletResponseReadAllDTO>> readAll() {
        return ResponseEntity.ok(palletService.readAll());
    }



    @GetMapping("/read-by-id/{id}")
    @Override
    public ResponseEntity<?> readById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(palletService.readById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
