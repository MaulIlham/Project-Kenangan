package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.Beauty;
import com.projectkenangan.ciladarawedding.services.BeautyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beauty")
public class BeautyController {
    @Autowired
    BeautyService beautyService;

    @GetMapping("")
    public List<Beauty> getAllDataBeauty(){
        return beautyService.getAllData();
    }

    @GetMapping("/{id}")
    public Beauty getDataBeautyById(@PathVariable String id){
        return beautyService.getDataById(id);
    }

    @PostMapping("")
    public Beauty saveDataBeauty(@RequestBody Beauty beauty){
        return beautyService.saveData(beauty);
    }

    @PutMapping("")
    public Beauty updateDataBeauty(@RequestBody Beauty beauty){
        return beautyService.saveData(beauty);
    }

    @DeleteMapping("/{id}")
    public void deleteDataBeautyById(@PathVariable String id){
        beautyService.deleteDataById(id);
    }
}
