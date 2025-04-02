package com.example.partly.Controller;
import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService service;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAllInventories(); // Korrekte Methode verwenden
    }

    @PostMapping
    public Inventory create(@RequestBody Inventory inventory) {
        return service.saveInventory(inventory); // Korrekte Methode verwenden
    }
}
