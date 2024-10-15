package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.utils.enu.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class CarrierLoadsAssignedResponseDTO {

    private Long id;
    private String username;
    private Role role;
    private Set<CarrierLoadsListAssignedResponseDTO> shipments;
}
