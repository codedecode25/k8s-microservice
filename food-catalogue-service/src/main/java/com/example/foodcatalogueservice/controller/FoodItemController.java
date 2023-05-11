package com.example.foodcatalogueservice.controller;

import com.example.foodcatalogueservice.Model.FoodItemResponse;
import com.example.foodcatalogueservice.Model.Restaurant;
import com.example.foodcatalogueservice.entity.FoodItems;
import com.example.foodcatalogueservice.repository.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/fooditems")
@CrossOrigin
public class FoodItemController {

    @Autowired
    private FoodItemRepo foodItemRepo;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ResponseEntity<FoodItems> addItems(@RequestBody FoodItems foodItem) {
        FoodItems items = foodItemRepo.save(foodItem);
        return new ResponseEntity<>(items, HttpStatus.ACCEPTED);
    }

    @RequestMapping(path = "/getitemsbyrestaurant/{id}", method = RequestMethod.GET)
    public ResponseEntity<FoodItemResponse> getFoodItemsByRestaurant(@PathVariable Integer id) {
        FoodItemResponse response = new FoodItemResponse();
        List<FoodItems> foodItems = foodItemRepo.findByRestaurantId(id);
        response.setFoodItems(foodItems);
        Restaurant restaurant = restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/id/" + id, Restaurant.class);
        response.setRestaurant(restaurant);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
