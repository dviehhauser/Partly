package com.example.partlybackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Inventory extends MainEntity {
    private String quantity;
    private String type;

    @OneToMany(mappedBy = "component")
    @JsonManagedReference("component-assembly")  // <- benannte Referenz
    private Set<AssemblyComponent> assemblies;
}
