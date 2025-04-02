package com.example.partly.Entity;

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

    @OneToMany(mappedBy = "electricalAssembly")
    private Set<ElectricalComponent> electricalComponents;
}