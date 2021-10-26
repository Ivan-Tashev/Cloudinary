package com.example.cloudinary.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.Uploader;
import com.example.cloudinary.service.CloudinaryService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {
    private final Cloudinary cloudinary;

    public CloudinaryServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        File tmpFile = File.createTempFile("tmp_", multipartFile.getOriginalFilename());
        multipartFile.transferTo(tmpFile);
        return cloudinary.uploader().upload(tmpFile, new HashMap<>())
                .get("url").toString();
    }
}
