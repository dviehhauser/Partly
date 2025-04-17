package com.example.partlybackend.Repository;

import com.example.partlybackend.Entity.ElectricalAssembly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricalAssemblyRepository extends JpaRepository<ElectricalAssembly, Integer> {
}
