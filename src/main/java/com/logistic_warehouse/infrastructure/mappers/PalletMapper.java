package com.logistic_warehouse.infrastructure.mappers;

import com.logistic_warehouse.application.dto.response.PalletDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseReadAllDTO;
import com.logistic_warehouse.application.dto.response.ShipmentListDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PalletMapper {

    PalletDTO toPalletEntityToPalletDTO(PalletEntity pallet);

    PalletResponseReadAllDTO toPalletToPalleResponseReadAllDTO(PalletEntity palletEntity);

    PalletResponseDTO toPalleEntityToPalleResponseDTO(PalletEntity palletEntity);


    ShipmentListDTO shipmentToShipmentListDTO(ShipmentEntity shipment);
}
