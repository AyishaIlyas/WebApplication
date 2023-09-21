package com.example.webapplication.service;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Lecturer;


import java.util.List;

public interface LecturerService {
    List<Lecturer> getAllLecturers();

    Lecturer addLecturer(Lecturer lecturer);

    Lecturer getLecturerById(int id);

    Lecturer updateLecturer(Lecturer lecturer);

    void deleteLecturerById(int id);

    List<Lecturer> findLecturerByKeyword(String lecId);
}
