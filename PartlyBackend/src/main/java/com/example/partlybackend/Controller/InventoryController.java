package com.example.partlybackend.Controller;
import com.example.partlybackend.Repository.InventoryRepository;
import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryService inventoryService;


    @GetMapping
    public List<Inventory> getInventories() {
        return inventoryService.getInventoriesWithComponents();
    }

    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }
}
