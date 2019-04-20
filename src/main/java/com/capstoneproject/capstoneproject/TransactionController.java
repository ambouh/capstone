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
        return "Transaction History" + categories;
    }
}
