package com.example.partlybackend.Controller;

import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

import com.example.partlybackend.DTO.ElectricalAssemblyDTO;

@RestController
@RequestMapping("/electricalAssemblies")
public class ElectricalAssemblyController {

    @Autowired
    private ElectricalAssemblyService service;


    @GetMapping
    public List<ElectricalAssemblyDTO> getAll() {
        return service.getAllAssemblies().stream()
                .map(service::convertToDTO)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssembly(@PathVariable Integer id) {
        service.deleteAssembly(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ElectricalAssembly> create(@RequestBody ElectricalAssemblyDTO dto) {
        ElectricalAssembly saved = service.createAssembly(dto);
        return ResponseEntity.ok(saved);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ElectricalAssembly> updateAssembly(
            @PathVariable Integer id,
            @RequestBody ElectricalAssemblyDTO dto) {

        ElectricalAssembly updatedAssembly = service.updateAssembly(id, dto);
        return ResponseEntity.ok(updatedAssembly);
    }

}
