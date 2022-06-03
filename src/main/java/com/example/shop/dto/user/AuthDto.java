package com.example.shop.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDto {
    private String email;
    private String password;
    private String token;
}
