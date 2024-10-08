package com.logistic_warehouse.domain.imodel;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.application.service.generic.Create;
import com.logistic_warehouse.application.service.generic.Delete;
import com.logistic_warehouse.domain.entities.PalletEntity;

public interface IModelPallet extends Create<PalletRequestCreateDTO,PalletEntity>,Delete<Long,PalletEntity> {
    PalletEntity update(PalletRequestCreateDTO palletRequestCreateDTO,Long id);
}
