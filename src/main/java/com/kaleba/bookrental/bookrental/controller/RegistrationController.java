package com.kaleba.bookrental.bookrental.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import com.kaleba.bookrental.bookrental.service.AdherentService;
import com.kaleba.bookrental.bookrental.service.UsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.dto.AdherentDto;
import com.kaleba.bookrental.bookrental.dto.UsersDto;
import com.kaleba.bookrental.bookrental.model.Users;
import com.kaleba.bookrental.bookrental.model.Role;

import java.time.LocalDateTime;

//import jakarta.validation.Valid;
@Controller
public class RegistrationController {
    
    @Autowired
    private AdherentService adherentService;
    private UsersService usersService;

    public RegistrationController(AdherentService adherentService, UsersService usersService) {
        this.adherentService = adherentService;
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String registerForm(Model model){
        Adherent adherent = new Adherent();
        Users user = new  Users();
        model.addAttribute("adherent", adherent);
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/new")
    public String saveUser(@ModelAttribute("adherent") AdherentDto adherentDto, @ModelAttribute("user") UsersDto userDto) {
        
        adherentService.saveAdherentWithCredential(adherentDto, userDto);

        return "redirect:/";


    }




    
}
