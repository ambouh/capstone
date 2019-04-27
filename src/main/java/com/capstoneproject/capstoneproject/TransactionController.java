package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/api")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    String viewAllHistory(@RequestParam int person_id) {
        List<String> categories = transactionRepository.getAllTransactionHistoryByID(person_id);
        return "Transaction History " + categories;
    }

    @GetMapping(path = "/all-ascending")
    public @ResponseBody
    String viewAllHistoryAscending(@RequestParam int person_id) {
        String categories = transactionRepository.getAllTransactionHistoryByIDAscending(person_id);
        return "Transaction History " + categories;
    }

    @GetMapping(path = "/transaction")
    public @ResponseBody
    String viewTransaction(@RequestParam int person_id, @RequestParam int transaction_id) {
        String transaction = transactionRepository.viewTransaction(person_id,transaction_id);
        return "Transaction  " + transaction;
    }

    @GetMapping(path = "/update-transaction-category")
    public @ResponseBody
    String updateTransactionCategory(@RequestParam String transaction_category, @RequestParam int person_id, @RequestParam int transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionCategory(transaction_category, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/update-transaction-date")
    public @ResponseBody
    String updateTransactionDate(@RequestParam String transaction_date, @RequestParam int person_id, @RequestParam int transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionDate(transaction_date, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/update-transaction-amount")
    public @ResponseBody
    String updateTransactionAmount(@RequestParam Double transaction_amount, @RequestParam int person_id, @RequestParam int transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionAmount(transaction_amount, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/add-transaction")
    public @ResponseBody
    String addTransaction(@RequestParam Double transaction_amount, @RequestParam int person_id, @RequestParam int transaction_id,
                          @RequestParam String transaction_date, @RequestParam String transaction_type, @RequestParam String transaction_category,
                          @RequestParam String transaction_memo, @RequestParam String transaction_merchant, @RequestParam String transaction_account_id) {
        String result = transactionRepository.addTransaction(transaction_amount, person_id, transaction_id, transaction_date,transaction_type,
                                                             transaction_category,transaction_memo,transaction_merchant,transaction_account_id);
        return result;
    }

    @GetMapping(path = "/remove-transaction")
    public @ResponseBody
    String removeTransaction(@RequestParam int transaction_id) {
        String result = transactionRepository.removeTransaction(transaction_id);
        return result;
    }
}
