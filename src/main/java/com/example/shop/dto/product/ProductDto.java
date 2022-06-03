package com.example.shop.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
    private Integer id;
    @NotBlank(message = ("Invalid name"))
    private String name;
    @NotBlank(message = ("Invalid description"))
    private String description;
    @NotBlank(message = ("Invalid rate"))
    private Integer rate;
    private Boolean visible;
    private ProductTypeDto productType;
    private Integer productTypeId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
