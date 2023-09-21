package com.example.webapplication.controller;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Lecturer;
import com.example.webapplication.entity.Student;
import com.example.webapplication.service.CourseService;
import com.example.webapplication.service.LecturerService;
import com.example.webapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReportController {

    private final StudentService studentService;
    private final CourseService courseService;
    private final LecturerService lecturerService;

    @Autowired
    public ReportController(StudentService studentService, CourseService courseService, LecturerService lecturerService) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.lecturerService = lecturerService;
    }

    @GetMapping("/report")
    public String getReport(Model model){
        //List<Student> students = studentService.getAllStudents();
        //model.addAttribute("students", students);
        return "report";
    }

    @PostMapping("/report")
    public String viewReport(@RequestParam("keyword") String keyword, Model model){
        List<Student> searchResults = studentService.findStudentByKeyword(keyword);
        List<Course> searchResults2 = courseService.findCourseByKeyword(keyword);
        List<Lecturer> searchResults3 = lecturerService.findLecturerByKeyword(keyword);
        model.addAttribute("students", searchResults);
        model.addAttribute("courses", searchResults2);
        model.addAttribute("lecturers",searchResults3);
        return "report";
    }
}
