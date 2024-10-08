package com.logistic_warehouse.application.dto.request;

import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.UserEntity;
import com.logistic_warehouse.utils.enu.ShipmentStatus;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShipmentRequestDTO {

    private Double weight;

    private Double dimensionLarge;

    private Double dimensionWidth;

    private Double dimensionHeight;

    private ShipmentStatus status;

    private Long pallet;

}
