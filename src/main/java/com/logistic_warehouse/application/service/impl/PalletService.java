package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.persistence.PalletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PalletService implements IModelPallet {

    @Autowired
    PalletRepository palletRepository;


    @Override
    public PalletEntity create(PalletRequestCreateDTO palletRequestCreateDTO) {

        PalletEntity pallet = PalletEntity.builder()
                .capacity(palletRequestCreateDTO.getCapacity())
                .location(palletRequestCreateDTO.getLocation())
                .status(palletRequestCreateDTO.getStatus())
                .build();
        return palletRepository.save(pallet);
    }

    @Override
    public PalletEntity delete(Long id) {

        Optional<PalletEntity> pallet = palletRepository.findById(id);

        if(pallet.isEmpty()){
            throw new EntityNotFoundException("pallet id no exist");
        }

         palletRepository.deleteById(id);

        return PalletEntity.builder()
                .capacity(pallet.get().getCapacity())
                .status(pallet.get().getStatus())
                .location(pallet.get().getLocation())
                .build();
    }

    @Override
    public PalletEntity update(PalletRequestCreateDTO palletRequestCreateDTO, Long id) {

         PalletEntity palletExist = palletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("pallet id not found"));

         palletExist.setCapacity(palletRequestCreateDTO.getCapacity());
         palletExist.setLocation(palletExist.getLocation());
         palletExist.setStatus(palletRequestCreateDTO.getStatus());

         return palletRepository.save(palletExist);
    }

}
