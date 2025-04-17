package com.example.partlybackend.Service;
import com.example.partlybackend.Entity.ElectricalAssembly;
import com.example.partlybackend.Repository.ElectricalAssemblyRepository;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository repository;

    public List<Inventory> getInventoriesWithComponents() {
        return repository.findAllInventoriesWithComponents();
    }


    public Inventory saveInventory(Inventory inventory) { // Richtig benennen
        return repository.save(inventory);
    }
}
