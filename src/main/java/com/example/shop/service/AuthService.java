package com.example.shop.service;

import com.example.shop.configuration.JwtTokenUtil;
import com.example.shop.dto.user.AuthDto;
import com.example.shop.dto.user.RegisterDto;
import com.example.shop.dto.user.UserDto;
import com.example.shop.entity.User;
import com.example.shop.entity.UserRole;
import com.example.shop.exception.BadRequest;
import com.example.shop.repository.UserRepository;
import com.example.shop.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private JwtTokenUtil jwtTokenUtil;
    private MessageService messageService;
    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private PasswordEncoder passwordEncoder;

    public String register(RegisterDto dto) {
        Optional<User> optional = userRepository.findByEmailOrContactAndDeletedAtIsNull(dto.getEmail(), dto.getContact());
        if (optional.isPresent()) {
            throw new BadRequest("User already exist");
        }
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setContact(dto.getContact());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setStatus(false);
        user.setCreatedAt(LocalDateTime.now());

        UserRole userRole = new UserRole();
        userRole.setName("ROLE_ADMIN");
        userRole.setCreatedAt(LocalDateTime.now());
        userRole.setStatus(true);
        userRoleRepository.save(userRole);

        userRepository.save(user);
        String token = jwtTokenUtil.generateAccessToken(user.getId(), user.getEmail());
        String link = "http://localhost:8080/auth/verfication" + token;
        String content = String.format("Please click %s for verification", link);
        try {
            messageService.send(user.getEmail(), "Isystem shop uz verification", content);
        } catch (Exception e){
            userRepository.delete(user);
            e.printStackTrace();
            return "Mail not delivered";
        }
        return "Please go to " + dto.getEmail() + " and verificate your data";
    }

    public AuthDto login(AuthDto dto) {
        Optional<User> optional =
                userRepository.findByEmailAndPasswordAndDeletedAtIsNull(dto.getEmail(), PasswordEncodeService.generateMD5(dto.getPassword()));
        if (optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        User user = optional.get();
        String token = jwtTokenUtil.generateAccessToken(user.getId(), user.getEmail());
        dto.setToken(token);
        return dto;
    }

    public UserDto verification(String token) {
        String username = jwtTokenUtil.getUsername(token);
        Optional<User> optional = userRepository.findByEmailAndDeletedAtIsNull(username);
        if (optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        User user = optional.get();
        user.setStatus(true);
        userRepository.save(user);
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setContact(user.getContact());
        return dto;
    }
}
