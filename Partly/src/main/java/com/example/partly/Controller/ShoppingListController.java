package com.example.partly.Controller;
import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/shoppingLists")
public class ShoppingListController {
    @Autowired
    private ShoppingListService service;

    @GetMapping
    public List<ShoppingList> getAll() {
        return service.getAllShoppingLists(); // Richtige Methode
    }

    @PostMapping
    public ShoppingList create(@RequestBody ShoppingList shoppingList) {
        return service.saveShoppingList(shoppingList); // Richtige Methode
    }
}
