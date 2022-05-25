package com.example.shop.entity;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private String contact;

    private Integer imageId;

    private String status;

    @ManyToOne
    @JoinColumn(name = ("user_role_id"),insertable = false,updatable = false)
    private UserRole userRole;

    @OneToOne
    @JoinColumn(name = ("image_id"),insertable = false,updatable = false)
    private Image image;

    @OneToOne
    @JoinColumn(name = ("address_id"),insertable = false,updatable = false)
    private Address address;

    @Column(name = ("user_role_id"))
    private Integer userRoleId;

    @Column(name = ("address_id"))
    private Integer addressId;
}
