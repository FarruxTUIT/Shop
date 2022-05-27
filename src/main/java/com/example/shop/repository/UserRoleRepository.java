package com.example.shop.repository;

import com.example.shop.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    Optional<UserRole> findByIdAndDeletedAtIsNull(Integer id);
}
