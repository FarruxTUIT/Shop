package com.example.shop.service;

import com.example.shop.dto.user.AuthDto;
import com.example.shop.dto.user.RegisterDto;
import com.example.shop.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    public boolean register(RegisterDto dto) {
        return false;
    }

    public AuthDto login(AuthDto dto) {
        return null;
    }

    public boolean verification(String token) {
        return false;
    }
}
