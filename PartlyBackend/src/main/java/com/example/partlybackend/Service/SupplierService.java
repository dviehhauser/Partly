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
public class SupplierService {
    private final SupplierRepository repository;

    // Get all suppliers
    public List<Supplier> getAll() {
        return repository.findAll(); // Ruft alle Lieferanten ab
    }

    // Create a new supplier
    public Supplier create(Supplier supplier) {
        return repository.save(supplier); // Speichert einen neuen Lieferanten
    }
}