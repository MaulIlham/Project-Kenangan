package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.FoodBeverage;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.FoodBeverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/foodbeverage")
public class FoodBeverageController {
    @Autowired
    FoodBeverageService foodBeverageService;

    @Autowired
    FileUtilService fileUtilService;

    @GetMapping()
    public List<FoodBeverage> getAllDataFoodBeverage(){
        return foodBeverageService.getAllData();
    }

    @GetMapping("/{id}")
    public FoodBeverage getDataFoodBeverageById(@PathVariable String id){
        return foodBeverageService.getDataById(id);
    }

    @GetMapping("/image/{path}")
    public ResponseEntity<Resource> getFileImage(@PathVariable String path, HttpServletRequest request){
        FoodBeverage foodBeverage=foodBeverageService.getDataById(path);
        if(foodBeverage==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        Resource resource= fileUtilService.read(foodBeverage.getId(),0);
        String contentType=null;
        try {
            contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format(Constant.FILENOTFOUNDMESSAGE));
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+resource.getFilename()+"\"")
                .body(resource);
    }

    @PostMapping()
    public FoodBeverage saveDataFoodBeverage(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException{
        return foodBeverageService.saveData(data,fileImage);
    }

    @PutMapping()
    public FoodBeverage updateDataFoodBeverage(@RequestPart MultipartFile[] fileImage, @RequestPart String data)throws IOException {
        return foodBeverageService.saveData(data,fileImage);
    }

    @DeleteMapping("/{id}")
    public void deleteDataFoodBeverageById(@PathVariable String id){
        foodBeverageService.deleteDataById(id);
    }
}
