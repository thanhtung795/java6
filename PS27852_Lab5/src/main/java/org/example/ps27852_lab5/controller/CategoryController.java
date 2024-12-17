package org.example.ps27852_lab5.controller;


import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Category;
import org.example.ps27852_lab5.service.CategorySetvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategorySetvice categorySetvice;

    @GetMapping
    public ResponseEntity<?> getAllCategories() {
        Map<String, Object> response = new LinkedHashMap();
        try {
            response.put("data", categorySetvice.getAllCategories());
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Integer id) {
        Map<String, Object> response = new LinkedHashMap();
        try {
            response.put("data", categorySetvice.getCategoryById(id));
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> addCategory(@RequestBody Category category) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            response.put("data", categorySetvice.saveCategory(category));
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@RequestBody Category category,@PathVariable Integer id) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            response.put("data", categorySetvice.updateCategory(category,id));
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Integer id) {
        Map<String, Object> response = new LinkedHashMap<>();
        try {
            categorySetvice.deleteCategory(id);
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
}
