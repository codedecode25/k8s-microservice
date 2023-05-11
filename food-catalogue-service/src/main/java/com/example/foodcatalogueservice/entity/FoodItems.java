package com.example.foodcatalogueservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class FoodItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String item;

    private String itemDescription;

    private boolean isVeg;

    private Number price;

    private Integer restaurantId;

    @Column(name = "count", nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer count;


}
