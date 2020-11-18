package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.entities.Image;
import com.projectkenangan.ciladarawedding.repositories.DressApparelRepository;
import com.projectkenangan.ciladarawedding.services.DressApparelService;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import com.projectkenangan.ciladarawedding.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DressApparelServiceImpl implements DressApparelService {
    @Autowired
    DressApparelRepository dressApparelRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<DressApparel> getAllData() {
        return dressApparelRepository.findAll();
    }

    @Override
    public DressApparel getDataById(String id) {
        return dressApparelRepository.findById(id).get();
    }

    @Override
    public DressApparel saveData(String data, MultipartFile[] fileImage) throws IOException {
        DressApparel dressApparel=objectMapper.readValue(data,DressApparel.class);
        dressApparel=dressApparelRepository.save(dressApparel);
        List<Image> images=new ArrayList<>();
        int num = 1;
        for (MultipartFile file: fileImage) {
            Image image=new Image(dressApparel.getId());
            image=imageService.saveDataImage(image,file,1);
            image.setDressApparel(dressApparel);
            image.setName("image "+dressApparel.getName()+num);
            images.add(image);
            num++;
        }
        dressApparel.setImages(images);
        return dressApparelRepository.save(dressApparel);
    }

    @Override
    public void deleteDataById(String id) {
        dressApparelRepository.deleteById(id);
    }
}
