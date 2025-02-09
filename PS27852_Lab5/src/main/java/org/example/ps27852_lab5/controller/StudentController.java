package org.example.ps27852_lab5.controller;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Student;
import org.example.ps27852_lab5.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        Map<String, Object> response = new LinkedHashMap();
        try {
            response.put("data", studentService.getAllStudents());
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
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", studentService.addStudent(student));
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @PutMapping
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", studentService.addStudent(student));
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteStudent(@PathVariable String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            studentService.deleteStudent(email);
            response.put("success", HttpStatus.OK);
            response.put("status", HttpStatus.OK.value());
        } catch (Exception e) {
            response.put("message", e.getMessage());
            response.put("success", HttpStatus.INTERNAL_SERVER_ERROR);
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{email}")
    public ResponseEntity<?> getStudentByEmail(@PathVariable String email) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("data", studentService.getStudentByEmail(email));
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
