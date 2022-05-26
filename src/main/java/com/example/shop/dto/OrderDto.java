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
public class OrderDto {
    private Integer id;
    private UserDto user;
    private Integer userId;
    private LocalDateTime deliveryDate;
    @NotBlank(message = ("Invalid requirement"))
    private String requirement;
    @NotBlank(message = ("Invalid contact"))
    private String contact;
    private String address;
    private LocalDateTime deliveredDate;
    private PostStatus status;
    private Double totalPayment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
