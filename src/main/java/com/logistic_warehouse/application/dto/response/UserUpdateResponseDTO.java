package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.utils.enu.Role;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@Builder
public class UserUpdateResponseDTO {

    private Long id;

    private String username;

    private Role role;

    private Set<ShipmentListDTO> shipments;
}
