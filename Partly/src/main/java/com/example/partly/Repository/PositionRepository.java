package com.example.partly.Repository;

import com.example.partly.Entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {
    // Hier können zusätzliche Abfragemethoden definiert werden
}