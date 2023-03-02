package com.contractManager.contractsManager.repositories;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="mobilePhoneContracts")
public class MobilePhoneContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Integer contractPeriod;
    
    @Column
    private float price;
    
    @Column
    private String network;
    
    @Column
    private String brand;

    @Column
    private boolean phoneFlat;
    
    @Column
    private boolean internetFlat;
    
    @Column
    private boolean messagingFlat;
    
}
