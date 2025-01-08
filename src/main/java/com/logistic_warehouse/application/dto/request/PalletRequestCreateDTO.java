package com.logistic_warehouse.application.dto.request;

import com.logistic_warehouse.utils.enu.PalletStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PalletRequestCreateDTO {

    @NotNull(message = "required capacity")
    private Double capacity;
    private PalletStatus status;
    @NotBlank(message = "required location")
    private String location;
}
