package com.example.partly.Controller;

import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    @Autowired
    private SupplierService service;

    @GetMapping
    public List<Supplier> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Supplier create(@RequestBody Supplier supplier) {
        return service.create(supplier);
    }
}
