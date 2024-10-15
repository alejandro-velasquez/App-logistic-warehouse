package com.logistic_warehouse.infrastructure.mappers;

import com.logistic_warehouse.application.dto.response.*;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PalletMapper {

    PalletDTO toPalletEntityToPalletDTO(PalletEntity pallet);

    PalletResponseReadAllDTO toPalletToPalleResponseReadAllDTO(PalletEntity palletEntity);

    PalletResponseDTO toPalleEntityToPalleResponseDTO(PalletEntity palletEntity);


    ShipmentListDTO shipmentToShipmentListDTO(ShipmentEntity shipment);

    CarrierListResponseDTO userToCarrierListResponseDTO(UserEntity user);
}
