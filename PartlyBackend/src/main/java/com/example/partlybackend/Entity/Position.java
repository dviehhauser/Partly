package com.example.partlybackend.Entity;

import com.sun.tools.javac.Main;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Position extends MainEntity {

    private Integer quantity;
    private Integer price;

    @ManyToOne
    private ShoppingList shoppingList;

    @ManyToOne
    private Supplier supplier;
}
