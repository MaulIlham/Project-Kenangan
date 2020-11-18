package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.FoodBeverage;
import com.projectkenangan.ciladarawedding.entities.Image;
import com.projectkenangan.ciladarawedding.repositories.FoodBeverageRepository;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.FoodBeverageService;
import com.projectkenangan.ciladarawedding.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FoodBeverageServiceImpl implements FoodBeverageService {
    @Autowired
    FoodBeverageRepository foodBeverageRepository;

    @Autowired
    ImageService imageService;

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
    public FoodBeverage saveData(String data, MultipartFile[] fileImage) throws IOException {
        FoodBeverage foodBeverage=objectMapper.readValue(data,FoodBeverage.class);
        foodBeverage=foodBeverageRepository.save(foodBeverage);
        List<Image> images = new ArrayList<>();
        int num=1;
        for (MultipartFile file: fileImage) {
            Image image=new Image(foodBeverage.getId());
            image=imageService.saveDataImage(image,file,2);
            image.setFoodBeverage(foodBeverage);
            image.setName("image "+foodBeverage.getName()+num);
            images.add(image);
            num++;
        }
        foodBeverage.setImages(images);
        return foodBeverageRepository.save(foodBeverage);
    }

    @Override
    public void deleteDataById(String id) {
        foodBeverageRepository.deleteById(id);
    }
}
