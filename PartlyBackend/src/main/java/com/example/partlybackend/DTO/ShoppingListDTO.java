package com.example.partlybackend.DTO;

import lombok.Data;
import java.util.List;

@Data
public class ShoppingListDTO {
    private String name;
    private String status;
    private List<ShoppingListComponentDTO> components;
}
