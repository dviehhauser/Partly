package com.example.partly.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter

public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer inventoryId;

    private String itemName;

    @ManyToOne
    @JoinColumn(name = "electrical_component_id")
    private ElectricalComponent electricalComponent;

    // other fields and getters/setters
}
