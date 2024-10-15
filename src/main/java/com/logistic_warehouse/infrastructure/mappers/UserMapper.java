package com.logistic_warehouse.infrastructure.mappers;

import com.logistic_warehouse.application.dto.request.RegisterRequestDTO;
import com.logistic_warehouse.application.dto.response.CarrierLoadsAssignedResponseDTO;
import com.logistic_warehouse.application.dto.response.CarrierLoadsListAssignedResponseDTO;
import com.logistic_warehouse.application.dto.response.RegisterResponseDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.control.MappingControl;

@Mapper(componentModel = "spring")
public interface UserMapper {

    RegisterResponseDTO registerRequestDTOToRegisterResponseDTO(RegisterRequestDTO registerRequestDTO);

    UserEntity registerRequestDTOToUserEntity(RegisterRequestDTO registerRequestDTO);

    CarrierLoadsAssignedResponseDTO userToCarrierLoadsAssignedDTO(UserEntity user);

    CarrierLoadsListAssignedResponseDTO shipmentToCarrierLoadsListDTO(ShipmentEntity shipment);



}
