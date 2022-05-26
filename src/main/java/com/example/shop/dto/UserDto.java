package com.example.shop.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Integer id;
    @NotBlank(message = "Invalid name")
    private String name;
    @NotBlank(message = "Invalid surname")
    private String surname;
    @NotBlank(message = "Invalid email")
    @Email
    private String email;
    @NotBlank(message = "Invalid password")
    @Size(min = 4)
    private String password;
    @NotBlank(message = "Invalid contact")
    @Size(min = 12,max = 13)
    private String contact;
    private String status;
    private Integer imageId;
    private Integer userRoleId;
    private Integer addressId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}

