package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class TransactionController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping(path = "/deposit")
    public @ResponseBody
    String deposit(@RequestParam int person_id, @RequestParam int amount) {
        return "Saved Deposit.";
    }

    @GetMapping(path = "/withdrawal")
    public @ResponseBody
    String withdrawal() {
        return "Saved Withdrawal.";
    }

    @GetMapping(path = "/transfer")
    public @ResponseBody
    String transfer(@RequestParam int incoming_person_id, @RequestParam int outgoing_person_id,
                    @RequestParam String outgoing_account, @RequestParam int amount) {
        return "Saved Withdrawal.";
    }


}
