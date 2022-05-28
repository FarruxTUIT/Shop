package com.example.shop.controller;

import com.example.shop.dto.OrderItemDto;
import com.example.shop.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order-item")
public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        OrderItemDto result = orderItemService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid OrderItemDto dto) {
        OrderItemDto result = orderItemService.create(dto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid OrderItemDto dto) {
        boolean result = orderItemService.update(id, dto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable ("id") Integer id){
        boolean result = orderItemService.delete(id);
        return  ResponseEntity.ok(result);
    }
}
