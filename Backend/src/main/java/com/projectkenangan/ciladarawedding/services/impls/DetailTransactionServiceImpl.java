package com.projectkenangan.ciladarawedding.services.impls;

import com.projectkenangan.ciladarawedding.entities.DetailTransaction;
import com.projectkenangan.ciladarawedding.repositories.DetailTransactionRepository;
import com.projectkenangan.ciladarawedding.services.DetailTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailTransactionServiceImpl implements DetailTransactionService {
    @Autowired
    DetailTransactionRepository detailTransactionRepository;

    @Override
    public List<DetailTransaction> getAllDataDetailTransaction() {
        return detailTransactionRepository.findAll();
    }

    @Override
    public DetailTransaction getDataDetailTransactionById(String id) {
        return detailTransactionRepository.findById(id).get();
    }

    @Override
    public DetailTransaction saveDataDetailTransaction(DetailTransaction data) {
        return detailTransactionRepository.save(data);
    }

    @Override
    public void deleteDataDetailTransactionById(String id) {
            detailTransactionRepository.deleteById(id);
    }
}
