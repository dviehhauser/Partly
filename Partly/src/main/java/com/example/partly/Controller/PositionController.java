package com.example.partly.Controller;

import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/positions")
public class PositionController {
    @Autowired
    private PositionService service;

    @GetMapping
    public List<Position> getAll() {
        return service.getAllPositions(); // Richtige Methode verwenden
    }

    @PostMapping
    public Position create(@RequestBody Position position) {
        return service.savePosition(position); // Richtige Methode verwenden
    }
}
