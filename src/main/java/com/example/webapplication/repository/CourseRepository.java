package com.example.webapplication.repository;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByCourseCodeContainingIgnoreCase(String keyword);
}
