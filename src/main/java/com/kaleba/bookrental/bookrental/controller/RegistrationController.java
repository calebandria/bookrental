package com.kaleba.bookrental.bookrental.controller;

import org.springframework.stereotype.Controller;
import com.kaleba.bookrental.bookrental.service.AdherentService;
import com.kaleba.bookrental.bookrental.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.kaleba.bookrental.bookrental.model.Adherent;

@Controller
public class RegistrationController {

    private AdherentService adherentService;
    private UsersService usersService;

    public RegistrationController(AdherentService adherentService, UsersService usersService) {
        this.adherentService = adherentService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String register(Model model){
        Adherent adherent = new Adherent();
        model.addAttribute("registrationForm", adherent);
        return "register";
    }


    
}
