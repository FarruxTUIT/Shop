package com.example.shop.service;

import com.example.shop.dto.OrderItemDto;
import com.example.shop.entity.OrderItem;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public OrderItemDto get(Integer id) {
        OrderItem orderItem = getEntity(id);
        OrderItemDto dto = new OrderItemDto();
        dto.setProduct(productService.get(dto.getProductId()));
        dto.setOrder(orderService.get(dto.getOrderId()));
        dto.setId(orderItem.getId());
        return dto;
    }


    public OrderItemDto create(OrderItemDto dto) {
        OrderItem orderItem = new OrderItem();
        //TODO: check product
        productService.getEntity(dto.getProductId());
        orderItem.setProductId(dto.getProductId());
        //TODO: check order
        orderService.getEntity(dto.getOrderId());
        orderItem.setOrderId(dto.getOrderId());

        orderItem.setCreatedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
        dto.setId(orderItem.getId());
        return dto;
    }

    public boolean update(Integer id, OrderItemDto dto) {
        OrderItem orderItem = getEntity(id);
        //TODO: check product
        productService.getEntity(dto.getProductId());
        orderItem.setProductId(dto.getProductId());
        //TODO: check order
        orderService.getEntity(dto.getOrderId());
        orderItem.setOrderId(dto.getOrderId());

        orderItem.setUpdatedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
        return true;
    }


    public boolean delete(Integer id) {
        OrderItem orderItem = getEntity(id);
        orderItem.setDeletedAt(LocalDateTime.now());
        orderItemRepository.save(orderItem);
        return true;
    }


    public OrderItem getEntity(Integer id) {
        Optional<OrderItem> optional = orderItemRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("ProductType not found");
        }
        return optional.get();
    }
}
