package org.example.ps27852_lab5.service;


import org.example.ps27852_lab5.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> getStudentByEmail(String email);
    Student addStudent(Student student);
    void deleteStudent(String email);
}
