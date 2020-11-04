package com.projectkenangan.ciladarawedding.services;

import com.projectkenangan.ciladarawedding.entities.Transaction;

import java.util.List;

public interface TransactionService{
    public List<Transaction> getAllDataTransaction();
    public Transaction getDataTransactionById(String id);
    public Transaction saveData(Transaction data);
    public void deleteDataTransactionById(String id);
}
