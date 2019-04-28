package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        return "Transaction History" + categories;
    }
}
