package com.example.partly.Service;
import com.example.partly.Entity.ElectricalAssembly;
import com.example.partly.Repository.ElectricalAssemblyRepository;
import com.example.partly.Entity.*;
import com.example.partly.Repository.*;
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
