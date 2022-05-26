package com.example.shop.repository;

import com.example.shop.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Optional<Address> findByIdAndDeletedAtIsNull(Integer id);
}
