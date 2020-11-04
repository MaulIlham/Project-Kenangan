package com.projectkenangan.ciladarawedding.controllers;

import com.projectkenangan.ciladarawedding.entities.DetailTransaction;
import com.projectkenangan.ciladarawedding.services.DetailTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detailtransaction")
public class DetailTransactionController {
    @Autowired
    DetailTransactionService detailTransactionService;

    @GetMapping()
    public List<DetailTransaction> getAllDataTransaction(){
        return detailTransactionService.getAllDataDetailTransaction();
    }

    @GetMapping("/{id}")
    public DetailTransaction getDataDetailTransactionById(@PathVariable String id){
        return detailTransactionService.getDataDetailTransactionById(id);
    }

    @PostMapping()
    public DetailTransaction saveDataDetailTransaction(@RequestBody DetailTransaction detailTransaction){
        return detailTransactionService.saveDataDetailTransaction(detailTransaction);
    }

    @PutMapping()
    public DetailTransaction updateDataDetailTransaction(@RequestBody DetailTransaction detailTransaction){
        return detailTransactionService.saveDataDetailTransaction(detailTransaction);
    }

    @DeleteMapping("/{id}")
    public void deleteDataDetailTransaction(@PathVariable String id){
        detailTransactionService.deleteDataDetailTransactionById(id);
    }
}
