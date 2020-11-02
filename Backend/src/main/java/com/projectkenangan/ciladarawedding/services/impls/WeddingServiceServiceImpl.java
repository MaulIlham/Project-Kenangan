package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.WeddingServices;
import com.projectkenangan.ciladarawedding.repositories.WeddingServiceRepository;
import com.projectkenangan.ciladarawedding.services.WeddingServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeddingServiceServiceImpl implements WeddingServiceService {
    @Autowired
    WeddingServiceRepository weddingServiceRepository;

    @Override
    public List<WeddingServices> getAllData() {
        return weddingServiceRepository.findAll();
    }

    @Override
    public WeddingServices getDataById(String id) {
        return weddingServiceRepository.findById(id).get();
    }

    @Override
    public WeddingServices saveData(WeddingServices entity) {
        return weddingServiceRepository.save(entity);
    }

    @Override
    public void deleteDataById(String id) {
        weddingServiceRepository.deleteById(id);
    }
}
