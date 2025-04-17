package com.example.partlybackend.Repository;

import com.example.partlybackend.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("SELECT i FROM Inventory i LEFT JOIN FETCH i.electricalComponent")
    List<Inventory> findAllInventoriesWithComponents();
    Inventory findByElectricalComponent_ComponentId(Integer componentId);
}
