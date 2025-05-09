package com.example.partlybackend.Controller;

import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.partlybackend.DTO.ElectricalAssemblyDTO;
import com.example.partlybackend.DTO.ComponentQuantityDTO;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RestController
@RequestMapping("/electricalAssemblies")
public class ElectricalAssemblyController {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ElectricalAssemblyService service;

    @GetMapping
    public List<ElectricalAssembly> getAll() {
        return service.getAllAssemblies();
    }

    @PostMapping
    public ResponseEntity<ElectricalAssembly> create(@RequestBody ElectricalAssemblyDTO dto) {
        ElectricalAssembly newAssembly = new ElectricalAssembly();
        newAssembly.setAssemblyName(dto.getAssemblyName());
        newAssembly.setDescription(dto.getDescription());

        Set<AssemblyComponent> components = new HashSet<>();
        for (ComponentQuantityDTO compDto : dto.getComponents()) {
            AssemblyComponent component = new AssemblyComponent();

            ElectricalComponent electricalComponent = entityManager.find(ElectricalComponent.class, compDto.getComponentId());

            if (electricalComponent == null) {
                return ResponseEntity.badRequest().body(null); 
            }

            component.setComponent(electricalComponent);
            component.setAssembly(newAssembly);
            component.setQuantity(compDto.getQuantity());
            components.add(component);
        }

        newAssembly.setComponents(components);

        ElectricalAssembly saved = service.saveAssembly(newAssembly);
        return ResponseEntity.ok(saved);
    }




}
