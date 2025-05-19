package com.example.partlybackend.Service;

import com.example.partlybackend.Entity.Category;
import com.example.partlybackend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }
    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public void deleteCategory(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Kategorie mit ID " + id + " existiert nicht.");
        }
        repository.deleteById(id);
    }
}
