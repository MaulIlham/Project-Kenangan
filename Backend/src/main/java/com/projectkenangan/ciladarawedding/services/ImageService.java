package com.projectkenangan.ciladarawedding.services;

import com.projectkenangan.ciladarawedding.entities.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ImageService {
    public List<Image> getAllDataImage();
    public Image getDataImageById(String id);
    public Image saveDataImage(Image image, MultipartFile fileImage, int flag) throws IOException;
    public void deleteDataImageById(String id);
}
