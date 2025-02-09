package org.example.ps27852_lab5.service;

import org.example.ps27852_lab5.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategorySetvice {
    List<Category> getAllCategories();
    Optional<Category> getCategoryById(Integer id);
    Category saveCategory(Category category);
    Category updateCategory(Category category, Integer id);
    void deleteCategory(Integer id);
}
