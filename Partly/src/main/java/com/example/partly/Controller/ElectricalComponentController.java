package com.example.partly.Controller;
import com.example.partly.Service.ElectricalAssemblyService;
import com.example.partly.Entity.*;
import com.example.partly.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/electricalComponents")
public class ElectricalComponentController {
    @Autowired
    private ElectricalComponentService service;

    @GetMapping
    public List<ElectricalComponent> getAll() {
        return service.getAllComponents(); // Korrekte Methode verwenden
    }

    @PostMapping
    public ElectricalComponent create(@RequestBody ElectricalComponent component) {
        return service.saveComponent(component); // Korrekte Methode verwenden
    }
}
