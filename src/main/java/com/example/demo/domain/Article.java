package com.example.demo.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long commentCount;

//    @Version
    private Long version;
}