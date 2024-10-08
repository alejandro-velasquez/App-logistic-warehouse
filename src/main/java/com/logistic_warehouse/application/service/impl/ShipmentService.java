package com.logistic_warehouse.application.service.impl;

import com.logistic_warehouse.application.dto.request.ShipmentRequestDTO;
import com.logistic_warehouse.application.dto.response.ShipmentCreateResponseDTO;
import com.logistic_warehouse.domain.entities.ShipmentEntity;
import com.logistic_warehouse.domain.imodel.IModelShipment;
import com.logistic_warehouse.infrastructure.persistence.ShipmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService implements IModelShipment {

    @Autowired
    ShipmentRepository shipmentRepository;
    @Override
    public ShipmentEntity create(ShipmentRequestDTO shipmentRequestDTO) {

        ShipmentEntity shipmentExist = shipmentRepository.findById(shipmentRequestDTO.getPallet()).orElseThrow(() -> new EntityNotFoundException("shipment id not found"));


        ShipmentEntity shipment = ShipmentEntity.builder()
                .weight(shipmentRequestDTO.getWeight())
                .dimensionLarge(shipmentRequestDTO.getDimensionLarge())
                .dimensionHeight(shipmentRequestDTO.getDimensionHeight())
                .dimensionWidth(shipmentRequestDTO.getDimensionWidth())
                .status(shipmentRequestDTO.getStatus())
                .pallet(shipmentExist.getPallet())
                .build();


       return shipmentRepository.save(shipment);
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
}
