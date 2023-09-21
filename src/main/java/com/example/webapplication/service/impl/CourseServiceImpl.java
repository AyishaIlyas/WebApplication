package com.example.webapplication.service.impl;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Student;
import com.example.webapplication.repository.CourseRepository;

import com.example.webapplication.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepository.findById(id).get();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findCourseByKeyword(String keyword){
        List<Course> CourseCodeList = courseRepository.findByCourseCodeContainingIgnoreCase(keyword);
        return CourseCodeList;
    }
}
