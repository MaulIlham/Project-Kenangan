package com.projectkenangan.ciladarawedding.services.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectkenangan.ciladarawedding.constants.Constant;
import com.projectkenangan.ciladarawedding.entities.Beauty;
import com.projectkenangan.ciladarawedding.repositories.BeautyRepository;
import com.projectkenangan.ciladarawedding.services.BeautyService;
import com.projectkenangan.ciladarawedding.services.FileUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class BeautyServiceImpl implements BeautyService {
    @Autowired
    BeautyRepository beautyRepository;

    @Autowired
    FileUtilService fileUtilService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Beauty> getAllData() {
        return beautyRepository.findAll();
    }

    @Override
    public Beauty getDataById(String id) {
        return beautyRepository.findById(id).get();
    }

    @Override
    public Beauty saveData(String data, MultipartFile fileImage) throws IOException {
        Beauty beauty=objectMapper.readValue(data,Beauty.class);
        beauty=beautyRepository.save(beauty);
        beauty.setImage(String.format(Constant.PATHIMAGEBEAUTY,fileUtilService.uploads(beauty.getId(),fileImage,0)));
        return beautyRepository.save(beauty);
    }

    @Override
    public void deleteDataById(String id) {
        beautyRepository.deleteById(id);
    }
}
