package com.logistic_warehouse.domain.entities;

import com.logistic_warehouse.utils.enu.ShipmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shipments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double weight;
    @Column(nullable = false)
    private Double dimensionLarge;
    @Column(nullable = false)
    private Double dimensionWidth;
    @Column(nullable = false)
    private Double dimensionHeight;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @ManyToOne
    @JoinColumn(name = "id_pallet")
    private PalletEntity pallet;

    @ManyToOne
    @JoinColumn(name = "id_user_carrier")
    private UserEntity userCarrier;

}
