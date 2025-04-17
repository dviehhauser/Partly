package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class ElectricalAssembly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assemblyId;

    private String assemblyName;
    private String description;

    @OneToMany(mappedBy = "electricalAssembly") // Das "mappedBy" zeigt auf die "electricalAssembly" Eigenschaft in der ElectricalComponent Entität
    private Set<ElectricalComponent> electricalComponents;
}