package com.example.partlybackend.Service;
import com.example.partlybackend.DTO.ComponentQuantityDTO;
import com.example.partlybackend.DTO.ElectricalAssemblyDTO;
import com.example.partlybackend.Entity.ElectricalAssembly;
import com.example.partlybackend.Repository.ElectricalAssemblyRepository;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ElectricalAssemblyService {

    private final ElectricalAssemblyRepository repository;
    private final InventoryRepository inventoryRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<ElectricalAssembly> getAllAssemblies() {
        return repository.findAll();
    }

    public Optional<ElectricalAssembly> getAssemblyById(int id) {
        return repository.findById(id);
    }

    public ElectricalAssembly saveAssembly(ElectricalAssembly assembly) {
        return repository.save(assembly);
    }

    public void deleteAssembly(int id) {
        repository.deleteById(id);
    }


    public ElectricalAssemblyDTO convertToDTO(ElectricalAssembly entity) {
        ElectricalAssemblyDTO dto = new ElectricalAssemblyDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setQuantity(entity.getQuantity());
        dto.setDescription(entity.getDescription());

        List<ComponentQuantityDTO> components = entity.getComponents().stream()
                .map(ac -> {
                    ComponentQuantityDTO compDto = new ComponentQuantityDTO();
                    compDto.setComponentId(ac.getComponent().getId());
                    compDto.setQuantity(ac.getQuantity());
                    return compDto;
                }).collect(Collectors.toList());

        dto.setComponents(components);
        return dto;
    }

    public ElectricalAssembly createAssembly(ElectricalAssemblyDTO dto) {
        ElectricalAssembly newAssembly = new ElectricalAssembly();
        newAssembly.setName(dto.getName());
        newAssembly.setDescription(dto.getDescription());
        newAssembly.setQuantity(dto.getQuantity());
        Set<AssemblyComponent> components = new HashSet<>();

        for (ComponentQuantityDTO compDto : dto.getComponents()) {
            System.out.println("Component ID: " + compDto.getComponentId() + ", Quantity: " + compDto.getQuantity());
            Inventory inventory = entityManager.find(Inventory.class, compDto.getComponentId());

            AssemblyComponent component = new AssemblyComponent();
            component.setComponent(inventory);
            component.setAssembly(newAssembly);
            component.setQuantity(compDto.getQuantity());
            components.add(component);
        }

        newAssembly.setComponents(components);
        System.out.println(components);
        return repository.save(newAssembly);
    }

    public void deleteAssembly(Integer id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Assembly not found with id: " + id);
        }

        repository.deleteById(id);
    }

}
