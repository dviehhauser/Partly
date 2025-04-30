package com.example.partlybackend.Controller;

import com.example.partlybackend.Entity.ElectricalComponent;
import com.example.partlybackend.Service.ElectricalComponentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/electricalComponents")
@RequiredArgsConstructor
public class ElectricalComponentController {

    private final ElectricalComponentService service;

    @GetMapping
    public List<ElectricalComponent> getAll() {
        return service.getAllComponents();
    }
    @PutMapping("/{id}")
    public ElectricalComponent updateComponent(@PathVariable int id, @RequestBody ElectricalComponent updatedComponent) {
        return service.updateComponent(id, updatedComponent);
    }

    @PostMapping
    public ElectricalComponent create(@RequestBody ElectricalComponent component) {
        return service.saveComponent(component);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteComponent(id);
    }

    @GetMapping("/{id}")
    public ElectricalComponent getById(@PathVariable int id) {
        return service.getComponentById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with id: " + id));
    }
}
