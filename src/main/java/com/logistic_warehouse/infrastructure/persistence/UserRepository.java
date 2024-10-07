package com.logistic_warehouse.infrastructure.persistence;

import com.logistic_warehouse.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
