package com.example.shop.repository;

import com.example.shop.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
    Optional<ProductType> findByIdAndDeletedAtIsNull(Integer id);
}
