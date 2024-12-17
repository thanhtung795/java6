package org.example.ps27852_lab5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab5.entity.Student;
import org.example.ps27852_lab5.repository.StudentRepository;
import org.example.ps27852_lab5.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentByEmail(String email) {
        return Optional.ofNullable(studentRepository.findById(email).orElse(null));
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(String email) {
        if (studentRepository.existsById(email)) {
            studentRepository.deleteById(email);
        }
        throw  new RuntimeException("Student not found");
    }
}