package com.example.partlybackend.Controller;

import com.example.partlybackend.DTO.ElectricalAssemblyDTO;
import com.example.partlybackend.Entity.ShoppingList;
import com.example.partlybackend.Service.ShoppingListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.partlybackend.DTO.ShoppingListDTO;
import com.example.partlybackend.DTO.ShoppingListComponentDTO;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.InventoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/shoppinglists")
public class ShoppingListController {

    
    private final ShoppingListService shoppingListService;

    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @GetMapping
    public List<ShoppingList> getAll() {
        return shoppingListService.getAll();
    }
    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> updateShoppingList(
            @PathVariable Integer id,
            @RequestBody ShoppingListDTO dto) {

        ShoppingList updatedShoppingList = shoppingListService.updateShoppingList(id, dto);
        return ResponseEntity.ok(updatedShoppingList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> getById(@PathVariable int id) {
        return shoppingListService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShoppingList> create(@RequestBody ShoppingListDTO dto) {
        return ResponseEntity.ok(shoppingListService.createFromDTO(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        shoppingListService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ShoppingList> updateStatus(@PathVariable int id, @RequestParam boolean completed) {
        return ResponseEntity.ok(shoppingListService.updateStatus(id, completed));
    }
}