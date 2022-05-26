package com.example.shop.entity;

import com.example.shop.Enum.PostStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("orders"))
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = ("user_id"), insertable = false, updatable = false)
    private User user;

    @Column(name = ("user_id"))
    private Integer userId;

    @Column(name = ("delivery_date"))
    private LocalDateTime deliveryDate;

    private String requirement;

    private String contact;

    private String address;

    @Column(name = ("delivered_date"))
    private LocalDateTime deliveredDate;

    private PostStatus status;

    @Column(name = ("total_payment"))
    private Double totalPayment;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}

