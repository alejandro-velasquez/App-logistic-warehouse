package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.utils.enu.PalletStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Setter
@Getter
@Builder
public class PalletResponseDTO {

    private Long id;
    private Double capacity;
    private PalletStatus status;
    private String location;
    private Set<ShipmentListDTO> shipments;
}
