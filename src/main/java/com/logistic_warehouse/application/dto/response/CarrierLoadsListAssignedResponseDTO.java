package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.utils.enu.ShipmentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Builder
public class CarrierLoadsListAssignedResponseDTO {
        private Long id;
        private Double weight;
        private Double dimensionLarge;
        private Double dimensionWidth;
        private Double dimensionHeight;
        private ShipmentStatus status;
}

