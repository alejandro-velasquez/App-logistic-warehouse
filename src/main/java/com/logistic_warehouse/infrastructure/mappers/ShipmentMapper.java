package com.logistic_warehouse.infrastructure.mappers;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.application.dto.response.*;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.utils.enu.ShipmentStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentCreateResponseDTO toShipmentRequestToShipmentResponse(ShipmentEntity shipmentEntity);

    ShipmentListDTO shipmentToShipmentListDTO(ShipmentEntity shipmentEntity);

    ShipmentEntity toShipmentRequestDTOToShipment(ShipmentUpdateRequestDTO shipmentUpdateRequestDTO);

    ShipmentUpdateResponseDTO toShipmentToShipmentResponseDTO(ShipmentEntity shipmentEntity);

    PalletDTO toLongToPalleDTO(Long pallet);

    PalletEntity toLongToPalleEntity(Long pallet);

    ShipmentPathResponseDTO shipmentToShipmentPatchDTO(ShipmentEntity shipmentEntity);

    ShipmentStatus stringToShipmentStatus(String status);

    UserEntity stringToUserEntity(String carrier);

    PalletDTO palletToPalleDTO(PalletEntity palletEntity);

    ShipmentUpdateCarrierResponseDTO userToUserResponseDTO(UserEntity userEntity);
}
