package com.example.partly.Repository;

import com.example.partly.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByElectricalComponent_ComponentId(Integer componentId);
}
