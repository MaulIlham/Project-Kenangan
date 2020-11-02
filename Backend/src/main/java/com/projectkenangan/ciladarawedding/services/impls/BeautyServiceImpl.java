package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.Beauty;
import com.projectkenangan.ciladarawedding.repositories.BeautyRepository;
import com.projectkenangan.ciladarawedding.services.BeautyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeautyServiceImpl implements BeautyService {
    @Autowired
    BeautyRepository beautyRepository;

    @Override
    public List<Beauty> getAllData() {
        return beautyRepository.findAll();
    }

    @Override
    public Beauty getDataById(String id) {
        return beautyRepository.findById(id).get();
    }

    @Override
    public Beauty saveData(Beauty entity) {
        return beautyRepository.save(entity);
    }

    @Override
    public void deleteDataById(String id) {
        beautyRepository.deleteById(id);
    }
}
