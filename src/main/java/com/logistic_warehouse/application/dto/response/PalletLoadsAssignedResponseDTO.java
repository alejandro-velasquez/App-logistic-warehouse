package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.utils.enu.PalletStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Builder
public class PalletLoadsAssignedResponseDTO {


    private Long id;

    private Double capacity;
    private PalletStatus status;
    private String location;
    private Set<ShipmentListDTO> shipments;

}
