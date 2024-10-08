package com.logistic_warehouse.infrastructure.controller.interfaces;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.infrastructure.controller.generic.Create;
import com.logistic_warehouse.infrastructure.controller.generic.Delete;
import com.logistic_warehouse.infrastructure.controller.generic.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPalletController extends Create<PalletRequestCreateDTO>, Delete<PalletEntity,Long>, Update<Long,PalletRequestCreateDTO> {
    @DeleteMapping("{id}")
    ResponseEntity<?> delete(@PathVariable Long id);
}
