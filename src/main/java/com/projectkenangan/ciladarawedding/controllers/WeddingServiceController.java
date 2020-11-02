package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.WeddingServices;
import com.projectkenangan.ciladarawedding.services.WeddingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weddingservice")
public class WeddingServiceController {
    @Autowired
    WeddingServiceService weddingServiceService;

    @GetMapping()
    public List<WeddingServices> getAllDataWeddingService(){
        return weddingServiceService.getAllData();
    }

    @GetMapping("/{id}")
    public WeddingServices getDataWeddingServiceById(@PathVariable String id){
        return weddingServiceService.getDataById(id);
    }

    @PostMapping()
    public WeddingServices saveDataWeddingService(@RequestBody WeddingServices weddingServices){
        return weddingServiceService.saveData(weddingServices);
    }

    @PutMapping()
    public WeddingServices updateDataWeddingService(@RequestBody WeddingServices weddingServices){
        return weddingServiceService.saveData(weddingServices);
    }

    @DeleteMapping("/{id}")
    public void deleteDataWeddingServiceById(@PathVariable String id){
        weddingServiceService.deleteDataById(id);
    }
}
