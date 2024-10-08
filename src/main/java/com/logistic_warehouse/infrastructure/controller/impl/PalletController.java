package com.logistic_warehouse.infrastructure.controller.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.controller.interfaces.IPalletController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pallets")
public class PalletController implements IPalletController {

    @Autowired
    IModelPallet palletService;
    @PostMapping("/create")
    @Override
    public ResponseEntity<?> create(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(palletService.create(palletRequestCreateDTO));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(palletService.delete(id));
    }



    @PutMapping("/update/{id}")
    @Override
    public ResponseEntity<?> update(@RequestBody @Valid PalletRequestCreateDTO palletRequestCreateDTO, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(palletService.update(palletRequestCreateDTO,id));
    }

    @Override
    public ResponseEntity<?> delete(PalletEntity palletEntity) {
        return null;
    }
}
