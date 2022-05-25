package com.example.shop.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name = ("userrole"))
public class UserRole {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String status;

}
