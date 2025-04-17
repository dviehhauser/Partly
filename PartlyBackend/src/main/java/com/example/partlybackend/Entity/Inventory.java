package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;


@Entity
@Getter
@Setter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lagerId;
    private String itemName;
    private String componentType;
    private int quantityInStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "component_id")
    private ElectricalComponent electricalComponent;
    @Column(name = "last_updated", insertable = false, updatable = false)
    private Timestamp lastUpdated;

    // Getter und Setter
}

