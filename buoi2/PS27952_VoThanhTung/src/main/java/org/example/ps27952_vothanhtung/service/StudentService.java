package org.example.ps27952_vothanhtung.service;

import org.example.ps27952_vothanhtung.entity.Employee;
import org.example.ps27952_vothanhtung.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(String maSV);
    Student addStudent(Student student);
    int deleteStudent(String maSV);
}
