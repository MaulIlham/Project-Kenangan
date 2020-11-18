package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.Image;
import com.projectkenangan.ciladarawedding.repositories.ImageRepository;
import com.projectkenangan.ciladarawedding.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageRepository imageRepository;

    @Autowired
    FileUtilServiceImpl fileUtilService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Image> getAllDataImage() {
        return imageRepository.findAll();
    }

    @Override
    public Image getDataImageById(String id) {
        return imageRepository.findById(id).get();
    }

    @Override
    public Image saveDataImage(Image image, MultipartFile fileImage, int flag) throws IOException {
        if (flag==0) {
            image.setUrl(String.format(Constant.PATHIMAGEBEAUTY,fileUtilService.uploads(image.getName(),fileImage,0)));
        }else if (flag==1){
            image.setUrl(String.format(Constant.PATHIMAGEDRESSAPPAREL,fileUtilService.uploads(image.getName(),fileImage,1)));
        }else if (flag==2){
            image.setUrl(String.format(Constant.PATHIMAGEFOODBEVERAGE,fileUtilService.uploads(image.getName(),fileImage,2)));
        }else if (flag==3){
            image.setUrl(String.format(Constant.PATHIMAGEVENUE,fileUtilService.uploads(image.getName(),fileImage,3)));
        }else {
            image.setUrl(String.format(Constant.PATHIMAGEWEDDINGSERVICE,fileUtilService.uploads(image.getName(),fileImage,4)));
        }
        return imageRepository.save(image);
    }

    @Override
    public void deleteDataImageById(String id) {
        imageRepository.deleteById(id);
    }
}
