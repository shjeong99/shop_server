package com.spacecl.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Getter
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer old;

    public void setOld(Integer old){
        if(this.old == null){
            this.old = 0;
        }

        if( 0 <= old && old < 100 )
        {
            this.old = old;
        }
    }

    public void setPlusOld(){
        if(this.old == null){
            this.old = 0;
        }

        if( 0 <= this.old && this.old < 99 )
            this.old += 1;
    }

//    public Integer getOld(){
//        return this.old;
//    }
}
