package com.example.shop.dto;

import com.example.shop.Enum.PostStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {
    private Integer id;
    @NotBlank(message = "Invalid region")
    private String region;
    @NotBlank(message = "Invalid city")
    private String city;
    @NotBlank(message = "Invalid district")
    private String district;
    @NotBlank(message = "Invalid street")
    private String street;
    @NotBlank(message = "Invalid home")
    private Integer home;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}


