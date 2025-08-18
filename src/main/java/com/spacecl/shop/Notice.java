package com.spacecl.shop;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.Date;

@Entity
@ToString
public class Notice {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(columnDefinition = "TEXT")
    public String title;

    @Column(nullable = false)
    public Date date;

}