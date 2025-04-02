package com.example.partly.Repository;

import com.example.partly.Entity.ElectricalAssembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalAssemblyRepository extends JpaRepository<ElectricalAssembly, Integer> {
    // Benutzerdefinierte Abfragen können hier hinzugefügt werden
}
