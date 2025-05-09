package com.example.partlybackend.Controller;

import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Service.*;
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
        return service.getAllPositions();
    }

    @PostMapping
    public Position create(@RequestBody Position position) {
        return service.savePosition(position);
    }
}
