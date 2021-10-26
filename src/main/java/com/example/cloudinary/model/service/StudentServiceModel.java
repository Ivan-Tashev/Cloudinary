package com.example.cloudinary.model.service;

import org.springframework.web.multipart.MultipartFile;

public class StudentServiceModel {
    private Long id;
    private String name;
    private MultipartFile img;

    public Long getId() {
        return id;
    }

    public StudentServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public MultipartFile getImg() {
        return img;
    }

    public StudentServiceModel setImg(MultipartFile img) {
        this.img = img;
        return this;
    }
}
