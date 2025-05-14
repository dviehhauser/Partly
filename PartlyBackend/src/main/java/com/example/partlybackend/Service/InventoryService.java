package com.example.partlybackend.Service;

import com.example.partlybackend.Entity.Inventory;
import com.example.partlybackend.Repository.InventoryRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository repository;

    public List<Inventory> getAllComponents() {
        return repository.findAll();
    }

    public Optional<Inventory> getComponentById(int id) {
        return repository.findById(id);
    }

    public Inventory saveComponent(Inventory component) {
        return repository.save(component);
    }

    public void deleteComponent(int id) {
        repository.deleteById(id);
    }

    public Inventory updateComponent(int id, Inventory updatedComponent) {
        Inventory existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with id: " + id));

        existing.setName(updatedComponent.getName());
        existing.setQuantity(updatedComponent.getQuantity());
        existing.setType(updatedComponent.getType());

        return repository.save(existing);
    }
}
