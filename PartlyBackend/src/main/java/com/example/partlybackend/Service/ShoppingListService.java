package com.example.partlybackend.Service;
import com.example.partlybackend.Entity.ElectricalAssembly;
import com.example.partlybackend.Repository.ElectricalAssemblyRepository;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ShoppingListService {
    private final ShoppingRepository repository;

    public List<ShoppingList> getAllShoppingLists() {
        return repository.findAll();
    }

    public ShoppingList saveShoppingList(ShoppingList shoppingList) {
        return repository.save(shoppingList);
    }
}
