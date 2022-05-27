package com.example.shop.entity;

import com.example.shop.Enum.PostStatus;
import com.example.shop.dto.MerchantDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("product_types"))
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer core;

    private String material;

    private String display;

    private Integer ram;

    @Column(name = ("camera_front"))
    private Integer cameraFront;

    @Column(name = ("camera_back"))
    private Integer cameraBack;

    private Integer storage;

    @ManyToOne
    @JoinColumn(name = ("merchant_id"), insertable = false, updatable = false)
    private Merchant merchant;

    @Column(name = ("merchant_id"))
    private Integer merchantId;

    @ManyToOne
    @JoinColumn(name = ("os_id"), insertable = false, updatable = false)
    private Os os;

    @Column(name = ("os_id"))
    private Integer osId;

    @ManyToOne
    @JoinColumn(name = ("brand_id"), insertable = false, updatable = false)
    private Brand brand;

    @Column(name = ("brand_id"))
    private Integer brandId;

    private PostStatus status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
