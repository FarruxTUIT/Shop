package com.example.shop.repository;

import com.example.shop.entity.Os;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OsRepository extends JpaRepository<Os, Integer> {
    Optional<Os> findByIdAndDeletedAtIsNull(Integer id);
}
