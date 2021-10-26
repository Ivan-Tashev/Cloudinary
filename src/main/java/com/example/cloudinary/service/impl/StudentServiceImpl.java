package com.example.cloudinary.service.impl;

import com.example.cloudinary.model.entity.StudentEntity;
import com.example.cloudinary.model.service.StudentServiceModel;
import com.example.cloudinary.model.view.StudentViewModel;
import com.example.cloudinary.repo.StudentRepo;
import com.example.cloudinary.service.CloudinaryService;
import com.example.cloudinary.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final CloudinaryService cloudinaryService;
    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(CloudinaryService cloudinaryService, StudentRepo studentRepo, ModelMapper modelMapper) {
        this.cloudinaryService = cloudinaryService;
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addStudent(StudentServiceModel studentServiceModel) throws IOException {
        MultipartFile img = studentServiceModel.getImg();
        String imageUrl = cloudinaryService.uploadImage(img);

        StudentEntity studentEntity = new StudentEntity()
                .setName(studentServiceModel.getName())
                .setImgUrl(imageUrl);
        studentRepo.save(studentEntity);
    }

    @Override
    public List<StudentViewModel> findAll() {
        return studentRepo.findAll().stream()
                .map(studentEntity -> modelMapper.map(studentEntity, StudentViewModel.class))
                .collect(Collectors.toList());
    }
}
