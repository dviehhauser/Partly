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
}