package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.PalletRequestCreateDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseDTO;
import com.logistic_warehouse.application.dto.response.PalletResponseReadAllDTO;
import com.logistic_warehouse.application.dto.response.ShipmentListDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelPallet;
import com.logistic_warehouse.infrastructure.mappers.PalletMapper;
import com.logistic_warehouse.infrastructure.mappers.ShipmentMapper;
import com.logistic_warehouse.infrastructure.persistence.PalletRepository;
import com.logistic_warehouse.infrastructure.persistence.ShipmentRepository;
import com.logistic_warehouse.utils.enu.PalletStatus;
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
        
        if(palletRequestCreateDTO.getCapacity() <= 0){
            throw new IllegalArgumentException("Error, el valor debe ser mayor a 0");
        }

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
            throw new EntityNotFoundException("Pallet no encontrado, intente con otro ID.");
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

         PalletEntity palletExist = palletRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Pallet ID no encontrado"));

         if(palletRequestCreateDTO.getCapacity() <= 0){
             throw new IllegalArgumentException("Error, el valor debe ser mayor a 0");
         }

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

    @Override
    public PalletResponseDTO readById(Long id) {
        Optional<PalletEntity> pallet = palletRepository.findById(id);

        if(pallet.isEmpty()){
            throw new EntityNotFoundException("Pallet ID no encontrado");
        }

        return palletMapper.toPalleEntityToPalleResponseDTO(pallet.get());
    }
}
