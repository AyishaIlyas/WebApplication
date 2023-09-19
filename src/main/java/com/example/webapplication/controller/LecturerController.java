package com.example.webapplication.controller;

import com.example.webapplication.entity.Lecturer;
import com.example.webapplication.service.LecturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LecturerController {

    private LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    //handle method
    @GetMapping("/lecturers")
    public String listLecturers(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "lecturers";
    }

    @GetMapping("/lecturers/lecturers_form")
    public String createLecturerForm(Model model) {
        Lecturer lecturer = new Lecturer();
        model.addAttribute("lecturer", lecturer);
        return "lecturers_form";

    }
    @PostMapping("/lecturers")
    public String addLecturer(@ModelAttribute("lecturer") Lecturer lecturer){
        lecturerService.addLecturer(lecturer);
        return "redirect:/lecturers";
    }

    //update request handler

    @GetMapping("/lecturers/edit/{id}")
    public String editLecturerForm(@PathVariable int id, Model model){
        model.addAttribute("lecturer", lecturerService.getLecturerById(id));
        return "edit_lecturer";



    }
    @PostMapping("/slecturers/{id}")
    public String updateLecturer(@PathVariable int id,
                                @ModelAttribute("lecturer") Lecturer lecturer,
                                Model model) {

        // get lecturer from database by id
        Lecturer existingLecturer = lecturerService.getLecturerById(id);
        existingLecturer.setId(id);
        existingLecturer.setName(lecturer.getName());
        existingLecturer.setEmail(lecturer.getEmail());
        existingLecturer.setPassword(lecturer.getPassword());

        // save updated lecturer object
        lecturerService.updateLecturer(existingLecturer);
        return "redirect:/lecturers";
    }

    //handler method to handle delete requests
    @GetMapping("/lecturers/{id}")
    public String deleteLecturer(@PathVariable int id){
        lecturerService.deleteLecturerById(id);
        return  "redirect:/lecturers";

    }



}
