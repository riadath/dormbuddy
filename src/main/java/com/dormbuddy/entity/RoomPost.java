package com.dormbuddy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class RoomPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userEmail;
    private String title; // initial description
    private String description; //detailed description
    private String keyFeatures;
    private String googleMapLink;
    private int vacancy; //amount of slots left (1/2/3 people etc.)
    private int capacity; //max capacity of the room
    private int windowCount;
    private int rent; // rent paid by each person in that room (not the entire room)
    private boolean prefGender; //0 is male , 1 is female (it's not a spectrum)
    private boolean isToiletAttached;
    private boolean isKitchenAvailable;

    @ManyToOne(targetEntity = Dimension.class)
    @JoinColumn(name="dimension_fk",referencedColumnName = "id")
    Dimension dimension;

    @ManyToOne(targetEntity = Address.class)
    @JoinColumn(name="address_fk",referencedColumnName = "id")
    Address address;


    @ManyToMany(targetEntity = Image.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_fk", referencedColumnName = "id")
    List<Image> images;

}
