package com.logistic_warehouse.domain.imodel;

import com.logistic_warehouse.application.dto.request.ShipmentAssignCarrierRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentPatchRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.application.dto.response.ShipmentAssignCarrierResponseDTO;
import com.logistic_warehouse.application.dto.response.ShipmentCreateResponseDTO;
import com.logistic_warehouse.application.dto.response.ShipmentPathResponseDTO;
import com.logistic_warehouse.application.dto.response.ShipmentUpdateResponseDTO;
import com.logistic_warehouse.application.service.generic.Create;
import com.logistic_warehouse.application.service.generic.ReadAll;
import com.logistic_warehouse.application.service.generic.ReadById;
import com.logistic_warehouse.application.service.generic.Update;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.utils.enu.ShipmentStatus;

public interface IModelShipment extends Create<ShipmentRequestDTO,ShipmentCreateResponseDTO>, ReadAll<ShipmentEntity>, ReadById<Long,ShipmentEntity>
                , Update<Long,ShipmentUpdateResponseDTO, ShipmentUpdateRequestDTO> {

    ShipmentPathResponseDTO updateStatus(ShipmentStatus status, Long id);
    ShipmentAssignCarrierResponseDTO assignCarrier(ShipmentAssignCarrierRequestDTO carrier, Long id);

}
