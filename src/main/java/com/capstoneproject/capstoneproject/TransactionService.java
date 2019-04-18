package com.capstoneproject.capstoneproject;

public interface TransactionService {

    public void makeDeposit(String person_id, double amount);

    public void makeWithdrawal(String person_id, double amount);

    public void makeTransfer(String person_id, String second_person_id, double amount);

}
