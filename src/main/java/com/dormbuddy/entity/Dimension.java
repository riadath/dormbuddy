package com.dormbuddy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //height and width are in feet
    private int width;
    private int height;
    public int getArea(){
        return width*height;
    }
}
