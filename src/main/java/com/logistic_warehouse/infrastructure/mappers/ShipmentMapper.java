package com.logistic_warehouse.infrastructure.mappers;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.application.dto.response.ShipmentCreateResponseDTO;
import com.logistic_warehouse.application.dto.response.ShipmentListDTO;
import com.logistic_warehouse.application.dto.response.ShipmentUpdateResponseDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentCreateResponseDTO toShipmentRequestToShipmentResponse(ShipmentEntity shipmentEntity);

    ShipmentListDTO shipmentToShipmentListDTO(ShipmentEntity shipmentEntity);

    ShipmentEntity toShipmentRequestDTOToShipment(ShipmentUpdateRequestDTO shipmentUpdateRequestDTO);

    ShipmentUpdateResponseDTO toShipmentToShipmentResponseDTO(ShipmentEntity shipmentEntity);
}
