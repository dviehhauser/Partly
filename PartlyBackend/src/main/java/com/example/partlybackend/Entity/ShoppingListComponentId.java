package com.example.partlybackend.Entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ShoppingListComponentId implements Serializable {
    private Integer shoppingList;
    private Integer component;
}
