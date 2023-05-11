package com.example.foodcatalogueservice.Model;

import com.example.foodcatalogueservice.entity.FoodItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemResponse {
    private List<FoodItems> foodItems;

    private Restaurant restaurant;
}
