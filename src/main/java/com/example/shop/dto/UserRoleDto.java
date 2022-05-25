package com.example.shop.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleDto {

    private Integer id;
    @NotBlank(message = "Invalid name")
    @Size(min = 3,max = 25)
    private String name;
    private String status;

}
