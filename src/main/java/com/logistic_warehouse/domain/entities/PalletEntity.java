package com.logistic_warehouse.domain.entities;

import com.logistic_warehouse.utils.enu.PalletStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pallets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double capacity;
    @Column(nullable = false)
    private PalletStatus status;

}
