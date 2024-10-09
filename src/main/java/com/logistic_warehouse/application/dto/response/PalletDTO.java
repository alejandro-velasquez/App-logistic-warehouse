package com.logistic_warehouse.application.dto.response;

import com.logistic_warehouse.utils.enu.PalletStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class PalletDTO {

    private Long id;
    private Double capacity;
    private PalletStatus status;
    private String location;
}
