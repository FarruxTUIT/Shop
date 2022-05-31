package com.example.shop.dto.order;

import com.example.shop.Enum.PostStatus;
import com.example.shop.dto.product.ProductDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto {
    private Integer id;
    private OrderDto order;
    private Integer orderId;
    private ProductDto product;
    private Integer productId;
    private PostStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
