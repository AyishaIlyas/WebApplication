package com.example.webapplication.service;

import com.example.webapplication.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student addStudent(Student student);

    Student getStudentById(int id);

    Student updateStudent(Student student);

    void deleteStudentById(int id);

    List<Student> findStudentByKeyword(String StudentId);
}
