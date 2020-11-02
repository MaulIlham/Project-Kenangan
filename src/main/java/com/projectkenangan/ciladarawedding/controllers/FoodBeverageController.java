package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.FoodBeverage;
import com.projectkenangan.ciladarawedding.services.FoodBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foodbeverage")
public class FoodBeverageController {
    @Autowired
    FoodBeverageService foodBeverageService;

    @GetMapping()
    public List<FoodBeverage> getAllDataFoodBeverage(){
        return foodBeverageService.getAllData();
    }

    @GetMapping("/{id}")
    public FoodBeverage getDataFoodBeverageById(@PathVariable String id){
        return foodBeverageService.getDataById(id);
    }

    @PostMapping()
    public FoodBeverage saveDataFoodBeverage(@RequestBody FoodBeverage foodBeverage){
        return foodBeverageService.saveData(foodBeverage);
    }

    @PutMapping()
    public FoodBeverage updateDataFoodBeverage(@RequestBody FoodBeverage foodBeverage){
        return foodBeverageService.saveData(foodBeverage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataFoodBeverageById(@PathVariable String id){
        foodBeverageService.deleteDataById(id);
    }
}
