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
    @JsonBackReference("assembly-component")  // <- passende Gegenreferenz
    private ElectricalAssembly assembly;

    @Id
    @ManyToOne
    @JsonBackReference("component-assembly")  // <- passende Gegenreferenz
    private ElectricalComponent component;

    private int quantity;
}
