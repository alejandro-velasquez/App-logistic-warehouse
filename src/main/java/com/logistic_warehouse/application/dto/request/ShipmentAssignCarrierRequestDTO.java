package com.logistic_warehouse.application.dto.request;

import com.logistic_warehouse.domain.entities.UserEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAssignCarrierRequestDTO {

    @NotBlank(message = "required username")
    private String userCarrier;

}
