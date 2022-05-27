package com.example.shop.repository;

import com.example.shop.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    Optional<Brand> findByIdAndDeletedAtIsNull(Integer id);
}
