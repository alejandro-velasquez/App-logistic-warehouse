package com.logistic_warehouse.infrastructure.controller.interfaces;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.infrastructure.controller.generic.Create;
import com.logistic_warehouse.infrastructure.controller.generic.Delete;
import com.logistic_warehouse.infrastructure.controller.generic.Update;

public interface IPalletController extends Create<PalletRequestCreateDTO>, Delete<PalletEntity,Long>, Update<Long,PalletRequestCreateDTO> {
}
