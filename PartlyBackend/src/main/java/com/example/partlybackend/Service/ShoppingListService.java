package com.example.partlybackend.Service;

import com.example.partlybackend.DTO.ElectricalAssemblyDTO;
import com.example.partlybackend.Entity.ShoppingList;
import com.example.partlybackend.Repository.ShoppingRepository;
import org.springframework.stereotype.Service;
import com.example.partlybackend.DTO.ShoppingListDTO;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.InventoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingListService {

    private final ShoppingRepository shoppingListRepository;
    private final InventoryRepository inventoryRepository;

    public ShoppingListService(ShoppingRepository shoppingListRepository, InventoryRepository inventoryRepository) {
        this.shoppingListRepository = shoppingListRepository;
        this.inventoryRepository = inventoryRepository;

    }

    public List<ShoppingList> getAll() {
        return shoppingListRepository.findAll();
    }

    public Optional<ShoppingList> getById(int id) {
        return shoppingListRepository.findById(id);
    }
    public ShoppingList updateShoppingList(Integer id, ShoppingListDTO dto) {
        ShoppingList existingShoppingList = shoppingListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingList not found with id: " + id));
        existingShoppingList.setName(dto.getName());
        existingShoppingList.setStatus(ShoppingListStatus.valueOf(dto.getStatus()));

        Set<ShoppingListComponent> newComponents = (Set<ShoppingListComponent>) dto.getComponents().stream()
                .map(shoppingListComponentDTO -> {

                    ShoppingListComponent component = new ShoppingListComponent();
                    component.setShoppingList(existingShoppingList);
                    component.setComponentId(shoppingListComponentDTO.getComponentId());
                    component.setQuantity(shoppingListComponentDTO.getQuantity());

                    return component;
                }).collect(Collectors.toSet());
        existingShoppingList.getComponents().addAll(newComponents);

        return shoppingListRepository.save(existingShoppingList);
    }

    public ShoppingList createFromDTO(ShoppingListDTO dto) {
        ShoppingList list = new ShoppingList();
        list.setName(dto.getName());
        list.setStatus(ShoppingListStatus.valueOf(dto.getStatus()));

        Set<ShoppingListComponent> components = dto.getComponents().stream().map(componentDTO -> {
            if (componentDTO.getComponentId() == null) {
                throw new RuntimeException("ComponentId is null in ShoppingListComponentDTO");
            }
            Inventory inventory = inventoryRepository.findById(componentDTO.getComponentId())
                    .orElseThrow(() -> new RuntimeException("Component not found with ID " + componentDTO.getComponentId()));

            ShoppingListComponent component = new ShoppingListComponent();
            component.setShoppingList(list);
            component.setComponentId(componentDTO.getComponentId());
            component.setQuantity(componentDTO.getQuantity());
            return component;
        }).collect(Collectors.toSet());


        list.setComponents(components);

        return shoppingListRepository.save(list);
    }

    public void delete(int id) {
        shoppingListRepository.deleteById(id);
    }

    public ShoppingList updateStatus(int id, boolean completed) {
        ShoppingList list = shoppingListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingList not found"));
        list.setStatus(completed ? ShoppingListStatus.COMPLETED
                : ShoppingListStatus.OPEN);
        return shoppingListRepository.save(list);

    }
}
