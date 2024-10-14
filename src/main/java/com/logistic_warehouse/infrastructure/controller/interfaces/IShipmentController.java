package com.logistic_warehouse.infrastructure.controller.interfaces;

import com.logistic_warehouse.application.dto.request.ShipmentPatchRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.infrastructure.controller.generic.*;
import com.logistic_warehouse.utils.enu.ShipmentStatus;
import org.springframework.http.ResponseEntity;

public interface IShipmentController extends Create<ShipmentRequestDTO>, Delete<ShipmentEntity,Long>, ReadAll<ShipmentEntity>, ReadById<Long>
                , Update<ShipmentUpdateRequestDTO,Long> {


    ResponseEntity<?> updateStatus(ShipmentStatus status, Long id);
}
