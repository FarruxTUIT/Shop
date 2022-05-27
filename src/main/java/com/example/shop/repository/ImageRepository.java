package com.example.shop.repository;

import com.example.shop.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findByIdAndDeletedAtIsNull(Integer id);
}
