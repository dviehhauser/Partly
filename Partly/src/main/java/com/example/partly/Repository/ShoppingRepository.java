package com.example.partly.Repository;

import com.example.partly.Entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ShoppingRepository extends JpaRepository<ShoppingList, Integer> {
    // Eigene Abfragen können hier ergänzt werden
}