package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.FoodBeverage;
import com.projectkenangan.ciladarawedding.repositories.FoodBeverageRepository;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.FoodBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class FoodBeverageServiceImpl implements FoodBeverageService {
    @Autowired
    FoodBeverageRepository foodBeverageRepository;

    @Autowired
    FileUtilService fileUtilService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<FoodBeverage> getAllData() {
        return foodBeverageRepository.findAll();
    }

    @Override
    public FoodBeverage getDataById(String id) {
        return foodBeverageRepository.findById(id).get();
    }

    @Override
    public FoodBeverage saveData(String data, MultipartFile fileImage) throws IOException {
        FoodBeverage foodBeverage=objectMapper.readValue(data,FoodBeverage.class);
        foodBeverage=foodBeverageRepository.save(foodBeverage);
        foodBeverage.setImage(String.format(Constant.PATHIMAGEFOODBEVERAGE,fileUtilService.uploads(foodBeverage.getId(),fileImage,2)));
        return foodBeverageRepository.save(foodBeverage);
    }

    @Override
    public void deleteDataById(String id) {
        foodBeverageRepository.deleteById(id);
    }
}
