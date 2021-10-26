package com.example.cloudinary.model.view;

public class StudentViewModel {
    private Long id;
    private String name;
    private String imgUrl;

    public Long getId() {
        return id;
    }

    public StudentViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public StudentViewModel setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }
}
