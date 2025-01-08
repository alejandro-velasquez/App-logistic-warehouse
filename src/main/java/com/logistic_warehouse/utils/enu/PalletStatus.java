package com.logistic_warehouse.utils.enu;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PalletStatus {
    AVAILABLE,
    USED,
    DAMAGED;

    @JsonCreator
    public static PalletStatus fromString(String status) {
        if (status == null) {
            return null;
        }
        try {
            return PalletStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado invalido, el valor debe ser DISPONIBLE, DAÑADO o USADO.");
        }
    }

    @JsonValue
    public String toValue() {
        return name().toUpperCase();
    }
}
