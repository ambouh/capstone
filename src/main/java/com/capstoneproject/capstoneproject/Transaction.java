package com.capstoneproject.capstoneproject;

import javax.persistence.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @ManyToOne
//    @JoinColumn(name = "PERSON_ID")
    private int person_id;

    /** Comma separate list of categories associated with the transaction.*/
    @Column(name = "TRANSACTION_CATEGORY")
    private String transactionCategory;

    /** Descriptor for the type of transaction. Exmaples include "POS","Deposit","Withdrawal","Online" */
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    /** Date of the transaction */
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

    /** Amount of the transaction. */
    @Column(name = "TRANSACTION_AMOUNT")
    private double transactionAmount;

    /** ID of the account the transaction is againt.
     * The default ID, meaning no specific account, is 0.
     * Users can add accounts with friendly names to keep
     * track of account balances. The ID of those accounts is
     * stored in this variable.
     */
    @Column(name = "TRANSACTION_ACCOUNT_ID")
    private int transactionAccountID;

    /** Merchant for the transaction, such as WaWa or Amazon. */
    @Column(name = "TRANSACTION_MERCHANT")
    private String transactionMerchant;

    /** A description for the transaction. */
    @Column(name = "TRANSACTION_MEMO")
    private String transactionMemo;

    /** A unique ID for the transaction; used internally by the program.
     * This should be  characters and be in the format of 'yyyyMMddUUUU####'.
     * The first part of the ID is built from the transaction date,
     * the second part from the last 4 of the user ID,
     * and the last segment is built from a random integer.*/
    @Column (name = "TRANSACTION_ID")
    private final long TRANSACTION_ID;

    /** Default constructor for the transaction class. */
    protected Transaction() {
        person_id = 00000002;
        transactionCategory = "TEST";
        transactionType = "TEST";
        transactionDate = new Date();
        transactionAmount = 0.01;
        transactionAccountID = 0;
        transactionMerchant = "Testington Studios";
        transactionMemo = "Created by transaction default constructor.";
        String pattern = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String personID = Integer.toString(person_id);
        int personLength = personID.length();
        if (personLength < 4) {
            for (int i = personLength; i < 4; i++) {
                personID = "0" + personID;
            }
            personLength = 4;
        }
        String stringID = (sdf.format(transactionDate) + personID.substring(personLength - 4,personLength) + (int)(Math.floor(Math.random() * 10001)));
        TRANSACTION_ID = Long.parseLong(stringID);
    }


    /** Overloaded constructor used when creating new transactions.
     * @param transactionCategory Comma separated list of categories associated with the transaction.
     * @param transactionType Used to classify transactions. Expamples include POS, Deposit, Withdrawal, Online.
     * @param transactionDate The date of the transaction. Should be a java DATE object.
     * @param transactionAmount Amount of the transaction stored as a double. Should be negative for spends.
     * @param transactionAccountID ID of the account the transaction is against. The default is '0', meaning no account.
     * @param transactionMerchant Merchant for the transaction. Example: WaWa, McDonalds, Amazon Inc.
     * @param transactionMemo A short description for the transaction.
     * @param person_id Unique ID referencing a user for the platform.
     */
    public Transaction(String transactionCategory, String transactionType, Date transactionDate,
                       double transactionAmount, int transactionAccountID, String transactionMerchant,
                       String transactionMemo, int person_id) {

        this.transactionCategory = transactionCategory;
        this.transactionType = transactionType;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionAccountID = transactionAccountID;
        this.transactionMerchant = transactionMerchant;
        this.transactionMemo = transactionMemo;
        this.person_id = person_id;
        String pattern = "yyyyMMdd";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String personID = Integer.toString(person_id);
        int personLength = personID.length();
        if (personLength < 4) {
            for (int i = personLength; i < 4; i++) {
                personID = "0" + personID;
            }
            personLength = 4;
        }
        String stringID = (sdf.format(transactionDate) + personID.substring(personLength - 4,personLength) +
                           (int)(Math.floor(Math.random() * 10001)));
        TRANSACTION_ID = Long.parseLong(stringID);
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

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getTransactionAccountID() {
        return transactionAccountID;
    }

    public void setTransactionAccountID(int transactionAccountID) {
        this.transactionAccountID = transactionAccountID;
    }

    public String getTransactionMerchant() {
        return transactionMerchant;
    }

    public void setTransactionMerchant(String transactionMerchant) {
        this.transactionMerchant = transactionMerchant;
    }

    public String getTransactionMemo() {
        return transactionMemo;
    }

    public void setTransactionMemo(String transactionMemo) {
        this.transactionMemo = transactionMemo;
    }

    public long getTransactionId() { return TRANSACTION_ID;}

    @Override
    public String toString() {
<<<<<<< HEAD
<<<<<<< HEAD
        String returnString = ("Transaction ID:" + TRANSACTION_ID + "; " +
                               "Person ID:" + person_id + "; " +
                               "Date: " + transactionDate + "; " +
                               "Type: " + transactionType + "; " +
                               "Merchant: " + transactionMerchant + "; " +
                               "Memo: " + transactionMemo + "; " +
                               "Account: " + transactionAccountID + "; " +
                               "Amount: " + transactionAmount + "; " +
                               "Categories: " + transactionCategory + "; ");

        return returnString;
=======
=======
>>>>>>> 9e3566d485ca7aa0a464b0409fe66c2fdc81e0e5
        return "Transaction{" +
                "person_id=" + person_id +
                ", transactionCategory='" + transactionCategory + '\'' +
                ", transactionType='" + transactionType + '\'' +
                ", transactionDate=" + transactionDate +
                ", transactionAmount=" + transactionAmount +
                ", transactionAccountID=" + transactionAccountID +
                ", transactionMerchant='" + transactionMerchant + '\'' +
                ", transactionMemo='" + transactionMemo + '\'' +
                ", TRANSACTION_ID=" + TRANSACTION_ID +
                '}';
<<<<<<< HEAD
>>>>>>> 9e3566d485ca7aa0a464b0409fe66c2fdc81e0e5
=======
>>>>>>> 9e3566d485ca7aa0a464b0409fe66c2fdc81e0e5
    }
}
