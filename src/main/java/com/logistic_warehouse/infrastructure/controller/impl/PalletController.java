package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseReadAllDTO;
import com.logistic_warehouse.application.handleerror.ErrorsResponse;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.controller.interfaces.IPalletController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
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
            @ApiResponse(responseCode = "400", description = "Invalid request body.",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = ErrorsResponse.class),
            examples = {
                    @ExampleObject(name = "Capacity lees to zero o equal",
                    value = "{\"message\":\"Capacidad debe ser mayor a 0.\"}"),
                    @ExampleObject(name = "Invalid Capacity Format",
                    value =  "{\"message\": \"Formato inválido para capacidad.\"}"),
                    @ExampleObject(name = "Invalid status value",
                    value = "{\"message\": \"Estado inválido. El valor debe ser DISPONIBLE, DAÑADO o USADO.\"}")
            })),
            @ApiResponse(responseCode = "409", description = "Palle ya existe.")
    })
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO) {

        palletService.create(palletRequestCreateDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pallet creado exitosamente");
    }

    @Operation(
            summary = "Delete a Pallet by ID",
            description = "Deletes a pallet based on its unique ID. If the pallet does not exist, a 'not found' error will be returned."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet borrado exitosamente."),
            @ApiResponse(responseCode = "404", description = "Pallet no encontrado, intente con otro ID."),
    })
    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        palletService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Pallet borrado exitosamente");
    }


    @Operation(
            summary = "Update an existing Pallet",
            description = "Updates the details of an existing pallet. The request body should contain the new information, and the ID should correspond to the pallet being updated."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pallet actualizado exitosamente."),
            @ApiResponse(responseCode = "400", description = "Invalid request body.",
            content = @Content(mediaType = "application/json",
            schema = @Schema(implementation = ErrorsResponse.class),
            examples = {
                    @ExampleObject(name = "Capacity lees to zero o equal",
                            value = "{\"message\":\"Capacidad debe ser mayor a 0.\"}"),
                    @ExampleObject(name = "Invalid Capacity Format",
                            value = "{\"message\": \"Formato inválido.\"}"),
                    @ExampleObject(name = "Invalid status value",
                            value = "{\"message\": \"Formato inválido.\"}")
            })),
            @ApiResponse(responseCode = "404", description = "Pallet ID no encontrado.")
    })
    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO, @PathVariable Long id) {

        palletService.update(palletRequestCreateDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body("Pallet actualizado exitosamente");
    }

    @Override
    public ResponseEntity<?> delete(PalletEntity palletEntity) {
        return null;
    }

    @Operation(
            summary = "Get all pallets",
            description = "Fetches a list of all pallets available in the system.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Se recupera exitosamente la lista de pallets"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            }
    )
    @GetMapping("/read-all")
    @Override
    public ResponseEntity<List<PalletResponseReadAllDTO>> readAll() {
        return ResponseEntity.ok(palletService.readAll());
    }


    @Operation(
            summary = "Get pallet by ID",
            description = "Get pallet with details",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get information of Pallet"),
                    @ApiResponse(responseCode = "404", description = "Pallet ID no encontrado")
            }
    )
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
