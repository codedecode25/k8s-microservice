package com.example.foodcatalogueservice.controller;

import com.example.foodcatalogueservice.entity.FoodItems;
import com.example.foodcatalogueservice.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<FoodItems> addItems(@RequestBody FoodItems foodItem) {
        FoodItems items = foodItemRepo.save(foodItem);
        return new ResponseEntity<>(items, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getitemsbyrestaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<FoodItems>> getFoodItemsByRestaurant(@PathVariable Integer id) {
        List<FoodItems> foodItems = foodItemRepo.findByRestaurantId(id);

        return new ResponseEntity<>(foodItems, HttpStatus.OK);
    }
}
