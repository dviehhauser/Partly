package com.example.partly.Repository;

import com.example.partly.Entity.ElectricalComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalComponentRepository extends JpaRepository<ElectricalComponent, Integer> {
    // Weitere Abfragemethoden hier definieren
}