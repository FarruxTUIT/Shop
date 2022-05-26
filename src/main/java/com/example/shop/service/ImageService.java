package com.example.shop.service;


import com.example.shop.dto.ImageDto;
import com.example.shop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageDto get(Integer id) {
        return null;
    }

    public ImageDto create(ImageDto imageDto) {
        return null;
    }

    public ImageDto update(Integer id, ImageDto imageDto) {
        return null;
    }

    public ImageDto delete(Integer id) {
        return null;
    }
}
