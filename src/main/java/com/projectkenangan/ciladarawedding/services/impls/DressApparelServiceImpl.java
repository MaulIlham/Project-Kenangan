package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.DressApparel;
import com.projectkenangan.ciladarawedding.repositories.DressApparelRepository;
import com.projectkenangan.ciladarawedding.services.DressApparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DressApparelServiceImpl implements DressApparelService {
    @Autowired
    DressApparelRepository dressApparelRepository;

    @Override
    public List<DressApparel> getAllData() {
        return dressApparelRepository.findAll();
    }

    @Override
    public DressApparel getDataById(String id) {
        return dressApparelRepository.findById(id).get();
    }

    @Override
    public DressApparel saveData(DressApparel entity) {
        return dressApparelRepository.save(entity);
    }

    @Override
    public void deleteDataById(String id) {
        dressApparelRepository.deleteById(id);
    }
}
