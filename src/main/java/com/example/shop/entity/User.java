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

    private String status;

    @ManyToOne
    @JoinColumn(name = ("user_role_id"),insertable = false,updatable = false)
    private UserRole userRole;

    @Column(name = ("user_role_id"))
    private Integer userRoleId;

    @OneToOne
    @JoinColumn(name = ("image_id"),insertable = false,updatable = false)
    private Image image;

    @Column(name = ("image_id"))
    private Integer imageId;

    @OneToOne
    @JoinColumn(name = ("address_id"),insertable = false,updatable = false)
    private Address address;

    @Column(name = ("address_id"))
    private Integer addressId;//4
}
