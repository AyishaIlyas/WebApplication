package com.example.webapplication.repository;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LecturerRepository extends JpaRepository<Lecturer, Integer> {
    List<Lecturer> findByLecIdContainingIgnoreCase(String keyword);
}
