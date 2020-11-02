package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.Venue;
import com.projectkenangan.ciladarawedding.repositories.VenueRepository;
import com.projectkenangan.ciladarawedding.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    VenueRepository venueRepository;

    @Override
    public List<Venue> getAllData() {
        return venueRepository.findAll();
    }

    @Override
    public Venue getDataById(String id) {
        return venueRepository.findById(id).get();
    }

    @Override
    public Venue saveData(Venue entity) {
        return venueRepository.save(entity);
    }

    @Override
    public void deleteDataById(String id) {
        venueRepository.deleteById(id);
    }
}
