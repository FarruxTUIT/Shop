package com.example.shop.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    @NotBlank(message = "Invalid name")
    @Size(min = 3,max = 25)
    private String name;
    @NotBlank(message = "Invalid surname")
    @Size(min = 3,max = 25)
    private String surname;
    @NotBlank(message = "Xatolik yuz berdi")
    @Email
    private String email;
    @NotBlank(message = "Parol xato")
    @Size(min = 8)
    private String password;
    @NotBlank(message = "Tog'ri kiriting")
    @Size(min = 12,max = 13)
    private String contact;
    private Integer imageId;
    private String status;
    private Integer userRoleId;
    private Integer addressId;
}

