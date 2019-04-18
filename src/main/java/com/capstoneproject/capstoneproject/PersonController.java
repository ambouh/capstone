package com.capstoneproject.capstoneproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/login")
    public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(path = "/validate")
    public @ResponseBody
    String validateCredentials () {
        return "User Login Successful.";
    }
}
