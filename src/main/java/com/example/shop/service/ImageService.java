package com.example.shop.service;


import com.example.shop.dto.user.ImageDto;
import com.example.shop.entity.Image;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public ImageDto get(Integer id) {
        Image image = getEntity(id);
        ImageDto imageDto = new ImageDto();
        imageDto.setId(image.getId());
        imageDto.setPath(image.getPath());
        imageDto.setSize(image.getSize());
        imageDto.setToken(UUID.randomUUID().toString());
        imageRepository.save(image);
        return imageDto;
    }

    public ImageDto create(ImageDto imageDto) {
        Image image = new Image();
        image.setPath(imageDto.getPath());
        image.setSize(imageDto.getSize());
        image.setToken(UUID.randomUUID().toString());
        image.setCreatedAt(LocalDateTime.now());
        imageRepository.save(image);
        image.setId(imageDto.getId());
        return imageDto;
    }

    public boolean update(Integer id, ImageDto imageDto) {
        Image update = new Image();
        update.setPath(imageDto.getPath());
        update.setSize(imageDto.getSize());
        update.setToken(UUID.randomUUID().toString());
        update.setUpdatedAt(LocalDateTime.now());
        imageRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        Image delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        return true;

    }

    public Image getEntity(Integer id) {
        Optional<Image> optional = imageRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Image not found");
        }
        return optional.get();
    }
}
