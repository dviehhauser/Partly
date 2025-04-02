package com.example.partly.Service;
import com.example.partly.Entity.ElectricalAssembly;
import com.example.partly.Repository.ElectricalAssemblyRepository;
import com.example.partly.Entity.*;
import com.example.partly.Repository.*;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ElectricalAssemblyService {
    private final ElectricalAssemblyRepository repository;

    public List<ElectricalAssembly> getAllAssemblies() {
        return repository.findAll();
    }

    public Optional<ElectricalAssembly> getAssemblyById(int id) {
        return repository.findById(id);
    }

    public ElectricalAssembly saveAssembly(ElectricalAssembly assembly) {
        return repository.save(assembly);
    }

    public void deleteAssembly(int id) {
        repository.deleteById(id);
    }
}