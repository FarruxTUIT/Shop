package com.example.shop.dto.product;

import com.example.shop.Enum.PostStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductTypeDto {
    private Integer id;
    @NotBlank(message = ("Invalid name"))
    private String name;
    @NotBlank(message = ("Invalid core"))
    private Integer core;
    @NotBlank(message = ("Invalid material"))
    private String material;
    @NotBlank(message = ("Invalid display"))
    private String display;
    @NotBlank(message = ("Invalid ram"))
    private Integer ram;
    @NotBlank(message = ("Invalid front camera"))
    private Integer cameraFront;
    @NotBlank(message = ("Invalid back camera"))
    private Integer cameraBack;
    @NotBlank(message = ("Invalid storage"))
    private Integer storage;
    private MerchantDto merchant;
    private Integer merchantId;
    private OsDto os;
    private Integer osId;
    private BrandDto brand;
    private Integer brandId;
    private PostStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
