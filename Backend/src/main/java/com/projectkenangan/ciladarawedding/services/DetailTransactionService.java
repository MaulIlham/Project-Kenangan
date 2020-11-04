package com.projectkenangan.ciladarawedding.services;

import com.projectkenangan.ciladarawedding.entities.DetailTransaction;

import java.util.List;

public interface DetailTransactionService {
    public List<DetailTransaction> getAllDataDetailTransaction();
    public DetailTransaction getDataDetailTransactionById(String id);
    public DetailTransaction saveDataDetailTransaction(DetailTransaction data);
    public void deleteDataDetailTransactionById(String id);
}
