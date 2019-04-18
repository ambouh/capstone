package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;

public class TransactionImplementation implements TransactionService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void makeDeposit(String person_id, double amount) {

    }

    @Override
    public void makeWithdrawal(String person_id, double amount) {

    }

    @Override
    public void makeTransfer(String person_id, String second_person_id, double amount) {

    }
}
