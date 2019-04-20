package com.capstoneproject.capstoneproject;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID")
    private int personId;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TOTAL_BALANCE")
    private double balance;
    @Column(name = "NUMBER_OF_WITHDRAWALS")
    private int withdrawals;
    @Column(name = "NUMBER_OF_DEPOSITS")
    private int deposits;
    @Column(name = "NUMBER_OF_TRANSFERS")
    private int transfers;
    @Column(name = "SAVINGS_BALANCE")
    private double savings;
    @Column(name = "CHECKING_BALANCE")
    private double checking;

    protected Person(){}

    public Person(String username, String password, double balance, int withdrawals, int deposits, int transfers, double savings, double checking) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.withdrawals = withdrawals;
        this.deposits = deposits;
        this.transfers = transfers;
        this.savings = savings;
        this.checking = checking;
    }

    public double getSavings() { return savings; }

    public void setSavings(double savings) { this.savings = savings; }

    public double getChecking() { return checking; }

    public void setChecking(double checking) { this.checking = checking; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(int withdrawals) {
        this.withdrawals = withdrawals;
    }

    public int getDeposits() {
        return deposits;
    }

    public void setDeposits(int deposits) {
        this.deposits = deposits;
    }

    public int getTransfers() {
        return transfers;
    }

    public void setTransfers(int transfers) {
        this.transfers = transfers;
    }

}
