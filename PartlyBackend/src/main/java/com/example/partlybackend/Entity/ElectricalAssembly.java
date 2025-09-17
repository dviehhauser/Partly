package com.example.partlybackend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class ElectricalAssembly extends MainEntity {
    private Integer quantity;
    private String description;

    @OneToMany(mappedBy = "assembly", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("assembly-component")
    private Set<AssemblyComponent> components = new HashSet<>();
}
