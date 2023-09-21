package com.example.webapplication.service.impl;
import com.example.webapplication.entity.Student;
import com.example.webapplication.repository.StudentRepository;
import com.example.webapplication.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);

    }

    @Override
    public void deleteStudentById(int id) {
            studentRepository.deleteById(id);
        }

    public List<Student> findStudentByKeyword(String keyword){
        List<Student> StudentIdList = studentRepository.findByStudentIdContainingIgnoreCase(keyword);
        return StudentIdList;
    }
}
