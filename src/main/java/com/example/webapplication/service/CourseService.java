package com.example.webapplication.service;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Student;


import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course addCourse(Course course);

    Course getCourseById(int id);

    Course updateCourse(Course course);

    void deleteCourseById(int id);

    List<Course> findCourseByKeyword(String courseCode);
}
