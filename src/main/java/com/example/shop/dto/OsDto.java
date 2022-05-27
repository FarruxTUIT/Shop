package com.example.shop.dto;

import com.example.shop.Enum.PostStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OsDto {
    private Integer id;
    @NotBlank(message = ("Invalid name"))
    private String name;
    private PostStatus status;
}
