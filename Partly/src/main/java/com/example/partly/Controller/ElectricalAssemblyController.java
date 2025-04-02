package com.example.partly.Controller;

import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/electricalAssemblies")

public class ElectricalAssemblyController {
    @Autowired
    private ElectricalAssemblyService service;

    @GetMapping
    public List<ElectricalAssembly> getAll() {
        return service.getAllAssemblies(); // Korrigiert: Methode existiert jetzt
    }

    @PostMapping
    public ElectricalAssembly create(@RequestBody ElectricalAssembly assembly) {
        return service.saveAssembly(assembly); // Korrigiert: Methode existiert jetzt
    }
}
