package com.example.shop.repository;

import com.example.shop.entity.Merchant;
import com.example.shop.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {
    Optional<Merchant> findByIdAndDeletedAtIsNull(Integer id);
}
