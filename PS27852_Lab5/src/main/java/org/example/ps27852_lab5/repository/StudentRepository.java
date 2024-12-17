package org.example.ps27852_lab5.repository;

import org.example.ps27852_lab5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
