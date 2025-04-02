package com.example.partly.Service;
import com.example.partly.Entity.ElectricalAssembly;
import com.example.partly.Repository.ElectricalAssemblyRepository;
import com.example.partly.Entity.*;
import com.example.partly.Repository.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository repository;

    public List<Inventory> getAllInventories() { // Richtig benennen
        return repository.findAll();
    }

    public Inventory saveInventory(Inventory inventory) { // Richtig benennen
        return repository.save(inventory);
    }
}
