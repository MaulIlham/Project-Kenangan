package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.Transaction;
import com.projectkenangan.ciladarawedding.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public List<Transaction> getAllDataTransaction(){
        return transactionService.getAllDataTransaction();
    }

    @GetMapping("/{id}")
    public Transaction getDataTransactionById(@PathVariable String id){
        return transactionService.getDataTransactionById(id);
    }

    @PostMapping()
    public Transaction saveDataTransaction(@RequestBody Transaction transaction){
        return transactionService.saveData(transaction);
    }

    @PutMapping()
    public Transaction updateDataTransaction(@RequestBody Transaction transaction){
        return transactionService.saveData(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteDataTransaction(@PathVariable String id){
        transactionService.deleteDataTransactionById(id);
    }
}
