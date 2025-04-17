package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer list_id;

    private String componentName;
    private Integer quantity;
}