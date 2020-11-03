package com.projectkenangan.ciladarawedding.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface GenericService<T> {
    public List<T> getAllData();
    public T getDataById(String id);
    public T saveData(String data, MultipartFile fileImage) throws IOException;
    public void deleteDataById(String id);
}
