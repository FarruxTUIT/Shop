package com.example.shop.service;

import com.example.shop.dto.user.UserRoleDto;
import com.example.shop.entity.UserRole;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserRoleDto get(Integer id) {
        UserRole userRole = getEntity(id);
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setName(userRole.getName());
        userRoleDto.setId(userRole.getId());
        return userRoleDto;
    }

    public UserRoleDto create(UserRoleDto userRoleDto) {
        UserRole userRole = new UserRole();
        userRole.setName(userRoleDto.getName());
        userRole.setCreatedAt(LocalDateTime.now());
        userRoleRepository.save(userRole);
        userRoleDto.setId(userRole.getId());
        return userRoleDto;
    }

    public boolean update(Integer id, UserRoleDto userRoleDto) {
        UserRole update = getEntity(id);
        update.setName(userRoleDto.getName());
        update.setUpdatedAt(LocalDateTime.now());
        userRoleRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        UserRole delete = getEntity(id);
        delete.setDeletedAt(LocalDateTime.now());
        userRoleRepository.save(delete);
        return true;
    }

    public UserRole getEntity(Integer id) {
        Optional<UserRole> optional = userRoleRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new BadRequest("UserRole not found");
        }
        return optional.get();
    }
}
