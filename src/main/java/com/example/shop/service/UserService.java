package com.example.shop.service;

import com.example.shop.dto.UserDto;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private AddressService addressService;

    public UserDto create(UserDto userDto) {
        return null;
    }

    public UserDto get(Integer id) {
        return null;
    }

    public UserDto update(Integer id, UserDto userDto) {
        return null;
    }

    public UserDto delete(Integer id) {
        return null;
    }
}
