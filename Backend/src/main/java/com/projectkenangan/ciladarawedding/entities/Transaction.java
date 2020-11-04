package com.projectkenangan.ciladarawedding.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GenericGenerator(name = "id_transaction",strategy = "uuid2")
    @GeneratedValue(generator = "id_transaction",strategy = GenerationType.IDENTITY)
    private String id;
    private String customerName;
    private String customerAddress;
    private String customerNumber;
    private String customerEmail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Date weddingDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Date transactionDate;
    private Integer totalPrice;

    @OneToMany(mappedBy = "transaction")
    private List<DetailTransaction> detailTransactions=new ArrayList<>();

    public Transaction() {
    }

    public Transaction(String id, String customerName, String customerAddress, String customerNumber, String customerEmail, Date weddingDate, Date transactionDate, Integer totalPrice, List<DetailTransaction> detailTransactions) {
        this.id = id;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerNumber = customerNumber;
        this.customerEmail = customerEmail;
        this.weddingDate = weddingDate;
        this.transactionDate = transactionDate;
        this.totalPrice = totalPrice;
        this.detailTransactions = detailTransactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Date getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(Date weddingDate) {
        this.weddingDate = weddingDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DetailTransaction> getDetailTransactions() {
        return detailTransactions;
    }

    public void setDetailTransactions(List<DetailTransaction> detailTransactions) {
        this.detailTransactions = detailTransactions;
    }
}
