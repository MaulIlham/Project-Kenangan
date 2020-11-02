package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.Venue;
import com.projectkenangan.ciladarawedding.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venue")
public class VenueController {
    @Autowired
    VenueService venueService;

    @GetMapping()
    public List<Venue> getAllDataVenue(){
        return venueService.getAllData();
    }

    @GetMapping("/{id}")
    public Venue getDataVenueById(@PathVariable String id){
        return venueService.getDataById(id);
    }

    @PostMapping()
    public Venue saveDataVenue(@RequestBody Venue venue){
        return venueService.saveData(venue);
    }

    @PutMapping()
    public Venue updateDataVenue(@RequestBody Venue venue){
        return venueService.saveData(venue);
    }

    @DeleteMapping("/{id}")
    public void deleteDataVenueById(@PathVariable String id){
        venueService.deleteDataById(id);
    }
}
