package com.example.partly.Repository;
import com.example.partly.Entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    // Benutzerdefinierte Methoden falls nötig
}