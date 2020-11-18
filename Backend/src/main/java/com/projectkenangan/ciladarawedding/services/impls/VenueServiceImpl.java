package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.Image;
import com.projectkenangan.ciladarawedding.entities.Venue;
import com.projectkenangan.ciladarawedding.repositories.VenueRepository;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.ImageService;
import com.projectkenangan.ciladarawedding.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class VenueServiceImpl implements VenueService {
    @Autowired
    VenueRepository venueRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Venue> getAllData() {
        return venueRepository.findAll();
    }

    @Override
    public Venue getDataById(String id) {
        return venueRepository.findById(id).get();
    }

    @Override
    public Venue saveData(String data, MultipartFile[] fileImage) throws IOException {
        Venue venue=objectMapper.readValue(data,Venue.class);
        venue=venueRepository.save(venue);
        List<Image> images = new ArrayList<>();
        int num=1;
        for (MultipartFile file: fileImage) {
            Image image=new Image(venue.getId());
            image=imageService.saveDataImage(image,file,3);
            image.setVenue(venue);
            image.setName("image "+venue.getName()+num);
            images.add(image);
            num++;
        }
        venue.setImages(images);
        return venueRepository.save(venue);
    }

    @Override
    public void deleteDataById(String id) {
        venueRepository.deleteById(id);
    }
}
