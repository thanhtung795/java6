package org.example.ps27852_lab5.repository;

import org.example.ps27852_lab5.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {
}
