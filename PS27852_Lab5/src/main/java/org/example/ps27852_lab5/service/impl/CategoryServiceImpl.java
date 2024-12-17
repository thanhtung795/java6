package org.example.ps27852_lab5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Category;
import org.example.ps27852_lab5.repository.CategoryRepository;
import org.example.ps27852_lab5.service.CategorySetvice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategorySetvice {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return Optional.ofNullable(categoryRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found")));
    }

    @Override
    public Category saveCategory(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            throw new RuntimeException("Category already exists");
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category, Integer id) {
        if (categoryRepository.existsById(id)) {
            category.setId(id);
            return categoryRepository.save(category);
        }
        throw new RuntimeException("Category not found");
    }

    @Override
    public void deleteCategory(Integer id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        }
        throw new RuntimeException("Category not found");
    }

}
