package com.example.partlybackend.Repository;

import com.example.partlybackend.Entity.ElectricalComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalComponentRepository extends JpaRepository<ElectricalComponent, Integer> {
}
