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
public class PositionService {
    private final PositionRepository repository;

    public List<Position> getAllPositions() { // Richtigen Namen verwenden
        return repository.findAll();
    }

    public Position savePosition(Position position) { // Richtigen Namen verwenden
        return repository.save(position);
    }
}
