package com.example.partlybackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(AssemblyComponentId.class)
public class AssemblyComponent {

    @Id
    @ManyToOne
    @JoinColumn(name = "assembly_id", nullable = false)
    @JsonBackReference("assembly-component")
    private ElectricalAssembly assembly;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    @JsonBackReference("component-assembly")
    private Inventory component;


    private int quantity;
}
