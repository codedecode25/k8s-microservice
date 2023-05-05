package com.example.foodcatalogueservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
}
