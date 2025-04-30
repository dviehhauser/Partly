package com.example.partlybackend.Service;

import com.example.partlybackend.Entity.ElectricalComponent;
import com.example.partlybackend.Repository.ElectricalComponentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectricalComponentService {

    private final ElectricalComponentRepository repository;

    public List<ElectricalComponent> getAllComponents() {
        return repository.findAll();
    }

    public Optional<ElectricalComponent> getComponentById(int id) {
        return repository.findById(id);
    }

    public ElectricalComponent saveComponent(ElectricalComponent component) {
        return repository.save(component);
    }

    public void deleteComponent(int id) {
        repository.deleteById(id);
    }
    public ElectricalComponent updateComponent(int id, ElectricalComponent updatedComponent) {
        ElectricalComponent existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with id: " + id));

        existing.setComponent_name(updatedComponent.getComponent_name());
        existing.setQuantity(updatedComponent.getQuantity());
        existing.setDescription(updatedComponent.getDescription());

        return repository.save(existing);
    }

}
