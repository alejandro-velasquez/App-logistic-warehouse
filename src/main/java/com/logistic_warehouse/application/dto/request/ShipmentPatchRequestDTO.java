package com.logistic_warehouse.application.dto.request;

import com.logistic_warehouse.utils.enu.ShipmentStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ShipmentPatchRequestDTO {

    private ShipmentStatus status;
}
