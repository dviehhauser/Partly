package com.example.partlybackend.Service;
import com.example.partlybackend.Entity.ElectricalAssembly;
import com.example.partlybackend.Repository.ElectricalAssemblyRepository;
import com.example.partlybackend.Entity.*;
import com.example.partlybackend.Repository.*;
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
