package com.example.webapplication.service;

import com.example.webapplication.entity.Course;


import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course addCourse(Course course);

    Course getCourseById(int id);
    Course updateCourse(Course course);

    void deleteCourseById(int id);
}
