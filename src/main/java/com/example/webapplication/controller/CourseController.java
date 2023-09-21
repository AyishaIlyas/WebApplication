package com.example.webapplication.controller;

import com.example.webapplication.entity.Course;
import com.example.webapplication.entity.Student;
import com.example.webapplication.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    //handle method
    @GetMapping("/courses")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourses());
        return "courses";
    }

    @GetMapping("/courses_form")
    public String createCourseForm(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "courses_form";

    }

    @GetMapping("/courses/courses_form")
    public String createCourseForm2(Model model) {
        Course course = new Course();
        model.addAttribute("course", course);
        return "courses_form";
    }
    @PostMapping("/courses")
    public String addCourse(@ModelAttribute("course") Course course, @RequestParam(name = "action", required = false) String action) {
        if ("submit".equals(action)) {
            // Add the course only when the "Submit" button is clicked
            courseService.addCourse(course);
        }
        return "redirect:/courses";
    }


    //update request handler
    @GetMapping("/courses/edit/{id}")
    public String editCourseForm(@PathVariable int id, Model model){
        model.addAttribute("course", courseService.getCourseById(id));
        return "edit_course";
    }
    @PostMapping("/courses/{id}")
    public String updateCourse(@PathVariable int id,
                               @ModelAttribute("course") Course course,
                               @RequestParam(name = "action", required = false) String action,
                               Model model) {

        if ("submit".equals(action)) {
            // get course from the database by id
            Course existingCourse = courseService.getCourseById(id);
            existingCourse.setId(id);
            existingCourse.setCourseName(course.getCourseName());
            existingCourse.setCourseCode(course.getCourseCode());

            // save updated course object
            courseService.updateCourse(existingCourse);
        }

        return "redirect:/courses";
    }

    //handler method to handle delete requests
    @GetMapping("/courses/{id}")
    public String deleteCourse(@PathVariable int id){
        courseService.deleteCourseById(id);
        return  "redirect:/courses";

    }

}
