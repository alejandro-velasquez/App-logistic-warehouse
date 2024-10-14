package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.utils.enu.ShipmentStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAssignCarrierResponseDTO {


    private Long id;

    private Double weight;

    private Double dimensionLarge;

    private Double dimensionWidth;

    private Double dimensionHeight;

    private ShipmentStatus status;

    private PalletDTO pallet;

    private ShipmentUpdateCarrierResponseDTO userCarrier;

}
