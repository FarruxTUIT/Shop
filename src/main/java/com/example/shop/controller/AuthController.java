package com.example.shop.controller;

import com.example.shop.dto.user.AuthDto;
import com.example.shop.dto.user.RegisterDto;
import com.example.shop.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDto dto){
        boolean result = authService.register(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody @Valid AuthDto dto){
        AuthDto result = authService.login(dto);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/verification/{token}")
    public ResponseEntity<?> verification(@PathVariable("token") String token){
        boolean result = authService.verification(token);
        return ResponseEntity.ok(result);
    }
}
