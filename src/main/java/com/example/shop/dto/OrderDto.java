package com.example.shop.dto;

import com.example.shop.Enum.PostStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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
    @Size(min = 12, max = 13)
    private String contact;
    @NotBlank(message = ("Invalid address"))
    private String address;
    private LocalDateTime deliveredDate;
    private PostStatus status;
    private Double totalPayment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
