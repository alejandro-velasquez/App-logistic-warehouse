package com.logistic_warehouse.infrastructure.controller.interfaces;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.infrastructure.controller.generic.Create;
import com.logistic_warehouse.infrastructure.controller.generic.Delete;
import com.logistic_warehouse.infrastructure.controller.generic.ReadAll;
import com.logistic_warehouse.infrastructure.controller.generic.ReadById;
import org.springframework.http.ResponseEntity;

public interface IShipmentController extends Create<ShipmentRequestDTO>, Delete<ShipmentEntity,Long>, ReadAll<ShipmentEntity>, ReadById<Long> {

}
