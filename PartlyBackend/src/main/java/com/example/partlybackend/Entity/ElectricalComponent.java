package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ElectricalComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer componentId;

    private String componentName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "electrical_assembly_id") // Der Foreign Key, der auf die `ElectricalAssembly` verweist
    private ElectricalAssembly electricalAssembly;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")  // Correct join for positionId
    private Position position;
}
