package com.example.partlybackend.Controller;

import com.example.partlybackend.Entity.Inventory;
import com.example.partlybackend.Service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAllComponents();
    }
    @PutMapping("/{id}")
    public Inventory updateComponent(@PathVariable int id, @RequestBody Inventory updatedComponent) {
        return service.updateComponent(id, updatedComponent);
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory component) {
        return service.saveComponent(component);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.deleteComponent(id);
    }

    @GetMapping("/{id}")
    public Inventory getById(@PathVariable int id) {
        return service.getComponentById(id)
                .orElseThrow(() -> new RuntimeException("Component not found with id: " + id));
    }
}
