package com.logistic_warehouse.domain.entities;

import com.logistic_warehouse.utils.enu.PalletStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity(name = "pallets")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PalletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double capacity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PalletStatus status;
    @Column(nullable = false)
    private String location;

    @OneToMany(mappedBy = "pallet")
    private Set<ShipmentEntity> shipments;

}
