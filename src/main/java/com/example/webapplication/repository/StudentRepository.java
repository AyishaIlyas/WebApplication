package com.example.webapplication.repository;

import com.example.webapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentIdContainingIgnoreCase(String keyword);
}
