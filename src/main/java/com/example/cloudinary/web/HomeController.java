package com.example.cloudinary.web;

import com.example.cloudinary.model.service.StudentServiceModel;
import com.example.cloudinary.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class HomeController {
    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String addImage(Model model, @ModelAttribute("studentServiceModel")
            StudentServiceModel studentServiceModel) throws IOException {
        studentService.addStudent(studentServiceModel); // get field as MultipartFile img
        model.addAttribute("students", studentService.findAll());
        return "home";
    }
}
