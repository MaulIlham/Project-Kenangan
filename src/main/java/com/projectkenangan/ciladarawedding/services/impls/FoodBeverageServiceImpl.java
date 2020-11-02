package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.FoodBeverage;
import com.projectkenangan.ciladarawedding.repositories.FoodBeverageRepository;
import com.projectkenangan.ciladarawedding.services.FoodBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodBeverageServiceImpl implements FoodBeverageService {
    @Autowired
    FoodBeverageRepository foodBeverageRepository;

    @Override
    public List<FoodBeverage> getAllData() {
        return foodBeverageRepository.findAll();
    }

    @Override
    public FoodBeverage getDataById(String id) {
        return foodBeverageRepository.findById(id).get();
    }

    @Override
    public FoodBeverage saveData(FoodBeverage entity) {
        return foodBeverageRepository.save(entity);
    }

    @Override
    public void deleteDataById(String id) {
        foodBeverageRepository.deleteById(id);
    }
}
