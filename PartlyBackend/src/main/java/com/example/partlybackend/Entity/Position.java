package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;

    private String componentName;
    private Integer quantity;
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id", referencedColumnName = "list_id") // Stellt sicher, dass 'shopping_list_id' korrekt referenziert wird
    private ShoppingList shoppingList;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
