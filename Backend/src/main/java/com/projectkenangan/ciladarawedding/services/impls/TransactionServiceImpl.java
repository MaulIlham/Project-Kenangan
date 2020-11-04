package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.Transaction;
import com.projectkenangan.ciladarawedding.repositories.TransactionRepository;
import com.projectkenangan.ciladarawedding.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllDataTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getDataTransactionById(String id) {
        return transactionRepository.findById(id).get();
    }

    @Override
    public Transaction saveData(Transaction data) {
        return transactionRepository.save(data);
    }

    @Override
    public void deleteDataTransactionById(String id) {
            transactionRepository.deleteById(id);
    }
}
