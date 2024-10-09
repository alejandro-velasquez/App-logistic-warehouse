package com.logistic_warehouse.domain.imodel;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.response.ShipmentCreateResponseDTO;
import com.logistic_warehouse.application.service.generic.Create;
import com.logistic_warehouse.application.service.generic.ReadAll;
import com.logistic_warehouse.application.service.generic.ReadById;
import com.logistic_warehouse.domain.entities.ShipmentEntity;

public interface IModelShipment extends Create<ShipmentRequestDTO,ShipmentCreateResponseDTO>, ReadAll<ShipmentEntity>, ReadById<Long,ShipmentEntity> {

}
