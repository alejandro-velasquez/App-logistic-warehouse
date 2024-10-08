package com.logistic_warehouse.infrastructure.persistence;

import com.logistic_warehouse.domain.entities.PalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalletRepository extends JpaRepository<PalletEntity,Long> {

    Optional<PalletEntity> findById(Long id);
}
