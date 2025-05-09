package com.example.partlybackend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Set;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class ShoppingList extends MainEntity{
    private Integer quantity;
}