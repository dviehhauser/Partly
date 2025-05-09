package com.example.partlybackend.Repository;

import com.example.partlybackend.Entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ShoppingRepository extends JpaRepository<ShoppingList, Integer> {
}