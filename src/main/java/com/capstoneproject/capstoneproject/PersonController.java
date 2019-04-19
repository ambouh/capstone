package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api")
    public class PersonController {

    @Autowired
    PersonRepository personRepository;

    Person person = new Person();

    @GetMapping(path = "/deposit")
    public @ResponseBody
    String deposit(@RequestParam int person_id, @RequestParam int amount) {
        return "Saved Deposit.";
    }

    @GetMapping(path = "/withdrawal")
    public @ResponseBody
    int withdrawal() {
      // int withdrawal = personRepository.
        return 1;
    }

    @GetMapping(path = "/transfer")
    public @ResponseBody
    String transfer(@RequestParam int incoming_person_id, @PathVariable int outgoing_person_id,
                    @RequestParam String outgoing_account, @RequestParam int amount) {
        return "Saved Withdrawal.";
    }

    @GetMapping(path = "/totalBalance")
    public @ResponseBody
    Integer totalBalance() {
        return personRepository.getTotalBalanceFromFirstUser(2);
    }
}
