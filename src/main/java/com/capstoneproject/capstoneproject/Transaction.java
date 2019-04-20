package com.capstoneproject.capstoneproject;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
    private int person_id;

    @Column(name = "TRANSACTION_CATEGORY")
    private String transactionCategory;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    protected Transaction(){}

    public Transaction(String transactionCategory, String transactionType, Date transactionDate) {
        this.transactionCategory = transactionCategory;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
