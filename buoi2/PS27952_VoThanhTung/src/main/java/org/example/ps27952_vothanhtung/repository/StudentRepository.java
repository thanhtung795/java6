package org.example.ps27952_vothanhtung.repository;


import org.example.ps27952_vothanhtung.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
