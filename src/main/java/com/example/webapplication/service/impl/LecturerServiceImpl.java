package com.example.webapplication.service.impl;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Lecturer;
import com.example.webapplication.repository.LecturerRepository;
import com.example.webapplication.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LecturerServiceImpl implements LecturerService {

    private LecturerRepository lecturerRepository;

    public LecturerServiceImpl(LecturerRepository lecturerRepository){
        this.lecturerRepository = lecturerRepository;
    }
    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer addLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturerById(int id) {
        return lecturerRepository.findById(id).get();
    }

    @Override
    public Lecturer updateLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteLecturerById(int id) {
        lecturerRepository.deleteById(id);
    }

    public List<Lecturer> findLecturerByKeyword(String keyword){
        List<Lecturer> LecIdList = lecturerRepository.findByLecIdContainingIgnoreCase(keyword);
        return LecIdList;
    }
}
