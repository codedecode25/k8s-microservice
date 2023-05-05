package com.example.foodcatalogueservice.repository;

import com.example.foodcatalogueservice.entity.FoodItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItems, Integer> {

    public List<FoodItems> findByRestaurantId(Integer id);
}
