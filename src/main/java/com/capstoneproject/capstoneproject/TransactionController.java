package com.capstoneproject.capstoneproject;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping(path = "/api")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    String viewAllHistory(@RequestParam int person_id) {
        List<String> categories = transactionRepository.getAllTransactionHistoryByID(person_id);
        String json = new Gson().toJson(categories);
        return json;
    }

    @GetMapping(path = "/all-ascending")
    public @ResponseBody
    String viewAllHistoryAscending(@RequestParam int person_id) {
        String categories = transactionRepository.getAllTransactionHistoryByIDAscending(person_id);
        return "Transaction History " + categories;
    }

    @GetMapping(path = "/transaction")
    public @ResponseBody
    String viewTransaction(@RequestParam int person_id, @RequestParam long transaction_id) {
        String transaction = transactionRepository.viewTransaction(person_id,transaction_id);
        if (transaction != null)
            return transaction;
        else
            return "Error retrieving transaction";
    }

    @GetMapping(path = "/update-transaction-category")
    public @ResponseBody
    String updateTransactionCategory(@RequestParam String transaction_category, @RequestParam int person_id, @RequestParam long transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionCategory(transaction_category, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/update-transaction-date")
    public @ResponseBody
    String updateTransactionDate(@RequestParam String transaction_date, @RequestParam int person_id, @RequestParam long transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionDate(transaction_date, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/update-transaction-amount")
    public @ResponseBody
    String updateTransactionAmount(@RequestParam Double transaction_amount, @RequestParam int person_id, @RequestParam long transaction_id) {
        String updatedTransaction = transactionRepository.updateTransactionAmount(transaction_amount, person_id, transaction_id);
        return "Transaction  " + updatedTransaction;
    }

    @GetMapping(path = "/add-transaction")
    public @ResponseBody
    String addTransaction(@RequestParam Double transaction_amount, @RequestParam int person_id, @RequestParam String transaction_date,
                          @RequestParam String transaction_type, @RequestParam String transaction_category, @RequestParam String transaction_memo,
                          @RequestParam String transaction_merchant, @RequestParam int transaction_account_id) {
        Date transactionDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sqlformatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        try {
            transactionDate = formatter.parse(transaction_date);
        }
        catch (ParseException e) {e.printStackTrace();}

        Transaction tempTransaction = new Transaction(transaction_category,transaction_type,transactionDate,transaction_amount,transaction_account_id,
                                                      transaction_merchant,transaction_memo,person_id);
        int result = transactionRepository.addTransaction(transaction_amount,person_id,tempTransaction.getTransactionId(),sqlformatter.format(transactionDate),transaction_type,
                                                          transaction_category,transaction_memo,transaction_merchant,transaction_account_id);

        if (result == 1)
            return viewAllHistory(person_id);
        else
            return ("Result is: " + result);
    }

    @GetMapping(path = "/addTransaction")
    public @ResponseBody
    String addTransaction(@RequestParam String transaction_merchant, @RequestParam int person_id,
                          @RequestParam Double transaction_amount, @RequestParam String transaction_category){
        Date transactionDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sqlformatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        try {
            transactionDate = formatter.parse("2019-05-01");
        }
        catch (ParseException e) {e.printStackTrace();}
        return addTransaction(transaction_amount, person_id, sqlformatter.format(transactionDate), transaction_category, transaction_category, transaction_category, transaction_merchant, 1);

    }

    @GetMapping(path = "/remove-transaction")
    public @ResponseBody
    String removeTransaction(@RequestParam int person_id,@RequestParam long transaction_id) {
        int result = transactionRepository.removeTransaction(person_id,transaction_id);
        if (result == 1)
            return "Transaction " + transaction_id + " successfully removed.";
        else
            return "Error removing transaction";
    }
}
