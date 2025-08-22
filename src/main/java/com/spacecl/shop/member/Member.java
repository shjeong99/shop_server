package com.spacecl.shop.member;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, columnDefinition = "TEXT", length = 1000)
    private String username;
    @Column(unique = true, nullable = false, columnDefinition = "TEXT", length = 1000)
    private String displayName;
    @Column(nullable = false)
    private String password;

}