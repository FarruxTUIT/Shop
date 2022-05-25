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
@Table(name = ("address"))
public class Address {

    @Id
    @GeneratedValue
    private Integer id;

    private String region;

    private String city;

    private String district;

    private String street;

    private Integer home;
}
