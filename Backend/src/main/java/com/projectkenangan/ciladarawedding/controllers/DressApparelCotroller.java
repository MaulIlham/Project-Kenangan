package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.services.DressApparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dressapparel")
public class DressApparelCotroller {
    @Autowired
    DressApparelService dressApparelService;

    @GetMapping()
    public List<DressApparel> getAllDataDressApparel(){
        return dressApparelService.getAllData();
    }

    @GetMapping("/{id}")
    public DressApparel getDataDressApparelById(@PathVariable String id){
        return dressApparelService.getDataById(id);
    }

    @PostMapping()
    public DressApparel saveDataDressApparel(@RequestBody DressApparel dressApparel){
        return dressApparelService.saveData(dressApparel);
    }

    @PutMapping()
    public DressApparel updateDataDressApparel(@RequestBody DressApparel dressApparel){
        return dressApparelService.saveData(dressApparel);
    }

    @DeleteMapping("/{id}")
    public void deleteDataDressApparelById(@PathVariable String id){
        dressApparelService.deleteDataById(id);
    }
}
