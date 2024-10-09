package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseReadAllDTO;
import com.logistic_warehouse.application.dto.response.ShipmentListDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.mappers.PalletMapper;
import com.logistic_warehouse.infrastructure.mappers.ShipmentMapper;
import com.logistic_warehouse.infrastructure.persistence.PalletRepository;
import com.logistic_warehouse.infrastructure.persistence.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PalletService implements IModelPallet {

    @Autowired
    PalletRepository palletRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    ShipmentMapper shipmentMapper;

    @Autowired
    PalletMapper palletMapper;

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

    @Override
    public List<PalletResponseReadAllDTO> readAll() {
        List<PalletEntity> pallets = palletRepository.findAll();
        return pallets.stream()
                .map(palletMapper::toPalletToPalleResponseReadAllDTO)
                .collect(Collectors.toList());
    }
}
