package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.Image;
import com.projectkenangan.ciladarawedding.entities.WeddingServices;
import com.projectkenangan.ciladarawedding.repositories.WeddingServiceRepository;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.ImageService;
import com.projectkenangan.ciladarawedding.services.WeddingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeddingServiceServiceImpl implements WeddingServiceService {
    @Autowired
    WeddingServiceRepository weddingServiceRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<WeddingServices> getAllData() {
        return weddingServiceRepository.findAll();
    }

    @Override
    public WeddingServices getDataById(String id) {
        return weddingServiceRepository.findById(id).get();
    }

    @Override
    public WeddingServices saveData(String data, MultipartFile[] fileImage) throws IOException {
        WeddingServices weddingServices=objectMapper.readValue(data,WeddingServices.class);
        weddingServices=weddingServiceRepository.save(weddingServices);
        List<Image> images = new ArrayList<>();
        int num=1;
        for (MultipartFile file: fileImage) {
            Image image=new Image(weddingServices.getId());
            image=imageService.saveDataImage(image,file,4);
            image.setWeddingServices(weddingServices);
            image.setName("image "+weddingServices.getName()+num);
            images.add(image);
            num++;
        }
        weddingServices.setImages(images);
        return weddingServiceRepository.save(weddingServices);
    }

    @Override
    public void deleteDataById(String id) {
        weddingServiceRepository.deleteById(id);
    }
}
