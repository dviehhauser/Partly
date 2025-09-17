package com.example.partlybackend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class ShoppingList extends MainEntity {

    @OneToMany(mappedBy = "shoppingList", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("shoppinglist-component")
    private Set<ShoppingListComponent> components = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private ShoppingListStatus status = ShoppingListStatus.OPEN;
}
