package com.projectkenangan.ciladarawedding.services;

import java.util.List;

public interface GenericService<T> {
    public List<T> getAllData();
    public T getDataById(String id);
    public T saveData(T entity);
    public void deleteDataById(String id);
}
