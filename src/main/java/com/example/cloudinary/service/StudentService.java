package com.example.cloudinary.service;

import com.example.cloudinary.model.service.StudentServiceModel;
import com.example.cloudinary.model.view.StudentViewModel;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    void addStudent(StudentServiceModel studentServiceModel) throws IOException;

    List<StudentViewModel> findAll();
}
