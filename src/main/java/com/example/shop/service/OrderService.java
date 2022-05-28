package com.example.shop.service;

import com.example.shop.dto.OrderDto;
import com.example.shop.entity.Order;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserService userService;

    public OrderDto get(Integer id) {
        Order order = getEntity(id);
        OrderDto dto = new OrderDto();
        dto.setUser(userService.get(dto.getUserId()));
        convertDtoToEntity(dto, order);
        return dto;
    }


    public OrderDto create(OrderDto dto) {
        Order order = new Order();
        //TODO: check user
        userService.getEntity(dto.getUserId());
        order.setUserId(dto.getUserId());

        convertEntityToDto(order, dto);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.save(order);
        dto.setId(order.getId());
        return dto;
    }

    public boolean update(Integer id, OrderDto dto) {
        Order order = getEntity(id);
        //TODO: check user
        userService.getEntity(dto.getUserId());
        order.setUserId(dto.getUserId());

        convertEntityToDto(order, dto);
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);
        return true;
    }


    public boolean delete(Integer id) {
        Order order = getEntity(id);
        order.setDeletedAt(LocalDateTime.now());
        orderRepository.save(order);
        return true;
    }

    public void convertDtoToEntity(OrderDto dto, Order order) {
        dto.setId(order.getId());
        dto.setRequirement(order.getRequirement());
        dto.setContact(order.getContact());
        dto.setAddress(order.getAddress());
        dto.setTotalPayment(order.getTotalPayment());
    }

    public void convertEntityToDto(Order order, OrderDto dto) {
        dto.setRequirement(order.getRequirement());
        dto.setContact(order.getContact());
        dto.setAddress(order.getAddress());
        dto.setTotalPayment(order.getTotalPayment());

    }


    public Order getEntity(Integer id) {
        Optional<Order> optional = orderRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Product not found");
        }
        return optional.get();
    }
}
