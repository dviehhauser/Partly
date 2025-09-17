package com.example.partlybackend.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@IdClass(ShoppingListComponentId.class)
public class ShoppingListComponent {

    @Id
    @ManyToOne
    @JoinColumn(name = "shopping_list_id", nullable = false)
    @JsonBackReference("shoppinglist-component")
    private ShoppingList shoppingList;

    private int componentId;

    private int quantity;
}
