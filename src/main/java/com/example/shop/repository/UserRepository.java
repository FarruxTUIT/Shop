package com.example.shop.repository;

import com.example.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByIdAndDeletedAtIsNull(Integer id);
    Optional<User> findByEmailAndDeletedAtIsNull(String email);
    Optional<User> findByEmailOrContactAndDeletedAtIsNull(String email, String contact);
    Optional<User> findByEmailAndPasswordAndDeletedAtIsNull(String email, String password);
}
