package com.spacecl.shop;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class Item {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT", length = 1000)
    private String title;
    private Integer price;

    public void setTitle(String title) {
        if(title != null ){
            this.title = title;
        }
    }

    public void setPrice(Integer price) {
        if(price != null){
            this.price = price;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }
}
