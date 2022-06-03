package com.example.shop.controller;

import com.example.shop.dto.user.UserRoleDto;
import com.example.shop.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
@RequestMapping("/user-role")
public class UserRoleController {
    private UserRoleService userRoleService;

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        UserRoleDto result = userRoleService.get(id);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid UserRoleDto userRoleDto) {
        UserRoleDto result = userRoleService.create(userRoleDto);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid UserRoleDto userRoleDto) {
        boolean result = userRoleService.update(id, userRoleDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        boolean result = userRoleService.delete(id);
        return ResponseEntity.ok(result);
    }
}
