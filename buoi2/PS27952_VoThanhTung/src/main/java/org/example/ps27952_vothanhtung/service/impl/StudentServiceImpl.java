package org.example.ps27952_vothanhtung.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.ps27952_vothanhtung.entity.Employee;
import org.example.ps27952_vothanhtung.entity.Student;
import org.example.ps27952_vothanhtung.repository.StudentRepository;
import org.example.ps27952_vothanhtung.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(String maSV) {
        return studentRepository.findById(maSV).orElse(null);
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public int deleteStudent(String maSV) {
        studentRepository.deleteById(maSV);
        return 1;
    }
}
