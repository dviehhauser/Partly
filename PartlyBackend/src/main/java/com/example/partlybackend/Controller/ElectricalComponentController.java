package com.example.partlybackend.Controller;
import com.example.partlybackend.Service.ElectricalAssemblyService;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Service.*;
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
