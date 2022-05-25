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
@Table(name = ("image"))
public class Image {

    @Id
    @GeneratedValue
    private Integer id;

    private String path;

    private String type;

    private String token;

    private Long size;

}
