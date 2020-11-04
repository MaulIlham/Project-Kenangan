package com.projectkenangan.ciladarawedding.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detail_transaction")
public class DetailTransaction {
    @Id
    @GenericGenerator(name = "id_transaction",strategy = "uuid2")
    @GeneratedValue(generator = "id_transaction",strategy = GenerationType.IDENTITY)
    private String id;
    private String itemName;
    private String itemCatagory;
    private String price;
    private String detail;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Jakarta")
    private Date dateTransaction;

    @ManyToOne()
    @JoinColumn(name = "id_transaction", nullable = true)
    @JsonIgnoreProperties("detailTransactions")
    private Transaction transaction;

    public DetailTransaction() {
    }

    public DetailTransaction(String id, String itemName, String itemCatagory, String price, String detail, Date dateTransaction, Transaction transaction) {
        this.id = id;
        this.itemName = itemName;
        this.itemCatagory = itemCatagory;
        this.price = price;
        this.detail = detail;
        this.dateTransaction= dateTransaction;
        this.transaction = transaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCatagory() {
        return itemCatagory;
    }

    public void setItemCatagory(String itemCatagory) {
        this.itemCatagory = itemCatagory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
