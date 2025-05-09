package com.example.partlybackend.Controller;
import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Service.*;
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
        return service.getAllShoppingLists();
    }

    @PostMapping
    public ShoppingList create(@RequestBody ShoppingList shoppingList) {
        return service.saveShoppingList(shoppingList);
    }
}
