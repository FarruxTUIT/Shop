package com.example.shop.repository;

import com.example.shop.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    Optional<OrderItem> findByIdAndDeletedAtIsNull(Integer id);
}
