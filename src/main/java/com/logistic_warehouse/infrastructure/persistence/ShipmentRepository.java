package com.logistic_warehouse.infrastructure.persistence;

import com.logistic_warehouse.domain.entities.ShipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<ShipmentEntity,Long> {
}
