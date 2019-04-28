package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RequestMapping(path = "/api", method = {RequestMethod.GET, RequestMethod.POST})
    public class PersonController {

    @Autowired
    PersonRepository personRepository;

    Person person = new Person();

//    @GetMapping(path = "/login")
//    public @ResponseBody
//    boolean validateLogin(@RequestParam(value = "username") String username,
//                          @RequestParam(value = "password") String password) {
//        personRepository.save(person);
//        return personRepository.findAllByUsernameAndPassword(username, password).isEmpty();
//    }

    @GetMapping(path = "/deposit")
    public @ResponseBody
    String deposit(@RequestParam int person_id, @RequestParam int amount) {
        int balance = personRepository.getTotalBalanceFromUser(person_id) + amount;
        personRepository.updateTotalBalanceForUser(balance, person_id);
        int deposits = personRepository.getTotalDepositsFromUser(person_id);
        deposits++;
        personRepository.updateTotalNumberOfDeposits(deposits, person_id);
        return "Successful Deposit";
    }

    @GetMapping(path = "/withdrawal")
    public @ResponseBody
    String withdrawal(@RequestParam int person_id, @RequestParam int amount) {
        int balance = personRepository.getTotalBalanceFromUser(person_id) - amount;
        personRepository.updateTotalBalanceForUser(balance, person_id);
        int withdrawals = personRepository.getTotalWithdrawalsFromUser(person_id);
        withdrawals++;
        personRepository.updateTotalNumberOfWithdrawals(withdrawals, person_id);
        return "Successful Withdrawal";
    }

    @GetMapping(path = "/transfer")
    public @ResponseBody
    String transfer(@RequestParam int incoming_person_id, @RequestParam int outgoing_person_id,
                     @RequestParam int amount) {
        int incomingBalance = personRepository.getTotalBalanceFromUser(incoming_person_id) - amount;
        personRepository.updateTotalBalanceForUser(incomingBalance, incoming_person_id);
        int incomingTransfers = personRepository.getTotalTransfersFromUser(incoming_person_id);
        incomingTransfers++;
        personRepository.updateTotalNumberOfTransfers(incomingTransfers, incoming_person_id);
        int outgoingBalance = personRepository.getTotalBalanceFromUser(outgoing_person_id) + amount;
        personRepository.updateTotalBalanceForUser(outgoingBalance, outgoing_person_id);
        return "Successful Transfer";
    }

    @GetMapping(path = "/totalBalance")
    public @ResponseBody
    String totalBalance(@RequestParam int person_id) {
        int balance = personRepository.getTotalBalanceFromUser(person_id);
        return "Total balance is: " + balance;
    }
}
