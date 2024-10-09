package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.request.ShipmentUpdateRequestDTO;
import com.logistic_warehouse.application.dto.response.PalletDTO;
import com.logistic_warehouse.application.dto.response.ShipmentCreateResponseDTO;
import com.logistic_warehouse.application.dto.response.ShipmentUpdateResponseDTO;
import com.logistic_warehouse.domain.entities.PalletEntity;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelShipment;
import com.logistic_warehouse.infrastructure.mappers.PalletMapper;
import com.logistic_warehouse.infrastructure.mappers.ShipmentMapper;
import com.logistic_warehouse.infrastructure.persistence.PalletRepository;
import com.logistic_warehouse.infrastructure.persistence.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ShipmentService implements IModelShipment {

    @Autowired
    PalletRepository palletRepository;
    @Autowired
    ShipmentRepository shipmentRepository;
    @Autowired
    ShipmentMapper shipmentMapper;

    @Autowired
    PalletMapper palletMapper;

    @Override
    public ShipmentCreateResponseDTO create(ShipmentRequestDTO shipmentRequestDTO) {

        Optional<PalletEntity> pallet = palletRepository.findById(shipmentRequestDTO.getPallet());
//        ShipmentEntity shipmentExist = shipmentRepository.findById(shipmentRequestDTO.getPallet()).orElseThrow(() -> new EntityNotFoundException("shipment id not found"));

        if(pallet.isPresent()){
            PalletEntity palletEntity = pallet.get();

            if(palletEntity.getCapacity() < shipmentRequestDTO.getWeight()){
            throw new IllegalArgumentException("pallet doesnt have capacity");
            }

        Set<ShipmentEntity> palletEntities = palletEntity.getShipments();

        Double totalWeightShipments = palletEntities.stream()
                .mapToDouble(ShipmentEntity::getWeight)
                .sum();

            if(totalWeightShipments + shipmentRequestDTO.getWeight() > palletEntity.getCapacity()){
            throw new IllegalArgumentException("You need to enter a lighter load");
            }
        }





        ShipmentEntity shipment = ShipmentEntity.builder()
                    .weight(shipmentRequestDTO.getWeight())
                    .dimensionLarge(shipmentRequestDTO.getDimensionLarge())
                    .dimensionHeight(shipmentRequestDTO.getDimensionHeight())
                    .dimensionWidth(shipmentRequestDTO.getDimensionWidth())
                    .status(shipmentRequestDTO.getStatus())
                    .pallet(pallet.orElse(null))
                    .build();


        shipmentRepository.save(shipment);

        PalletDTO palletDTO = null;
        if (pallet.isPresent()) {
            PalletEntity palletEntity = pallet.get();
            palletDTO = PalletDTO.builder()
                    .id(palletEntity.getId())
                    .status(palletEntity.getStatus())
                    .capacity(palletEntity.getCapacity())
                    .location(palletEntity.getLocation())
                    .build();
        }


        ShipmentCreateResponseDTO shipmentCreateResponseDTO = shipmentMapper.toShipmentRequestToShipmentResponse(shipment);
        shipmentCreateResponseDTO.setPallet(palletDTO);

        return shipmentCreateResponseDTO;
    }




    @Override
    public List<ShipmentEntity> readAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public ShipmentEntity readById(Long id) {

        ShipmentEntity shipment = shipmentRepository.findById(id).orElseThrow(()->new EntityNotFoundException("shipment id not exist"));

        return shipment;
    }



    @Override
    public ShipmentUpdateResponseDTO update(ShipmentUpdateRequestDTO shipmentUpdateRequestDTO, Long id) {

        Optional<ShipmentEntity> shipment = shipmentRepository.findById(id);

        if(shipment.isEmpty()){
            throw new EntityNotFoundException("entity with " + id + " not found");
        }

       ShipmentEntity shipmentSave =  shipmentRepository.save(shipmentMapper.toShipmentRequestDTOToShipment(shipmentUpdateRequestDTO));



        return shipmentMapper.toShipmentToShipmentResponseDTO(shipmentSave);
    }
}
