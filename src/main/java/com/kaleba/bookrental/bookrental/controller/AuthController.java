package com.kaleba.bookrental.bookrental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.kaleba.bookrental.bookrental.dto.LoginDto;
import com.kaleba.bookrental.bookrental.dto.RegistrationDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.service.RegistrationService;
import org.springframework.security.authentication.AuthenticationManager;

import jakarta.validation.Valid;

import org.springframework.ui.Model;

@Controller
public class AuthController {
    
    private RegistrationService registrationService;
    private AuthenticationManager authenticationManager;

    public AuthController(RegistrationService registrationService, AuthenticationManager authenticationManager) {
        super();
        this.registrationService = registrationService;
        this.authenticationManager = authenticationManager;
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model){
        LoginDto loginDto = new LoginDto();
        model.addAttribute("loginForm", loginDto);
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginForm") LoginDto form, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "login";
        }

        return "redirect:/landing";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        Adherent adherent = new Adherent();
        model.addAttribute("registrationForm", adherent);
        return "register";
    }

    @PostMapping("/register/save")
    public String registerUser(@Valid @ModelAttribute("registrationForm") RegistrationDto form, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "register";
        }

        boolean success = registrationService.registerUser(form);

        if(!success){
            result.rejectValue("username", "error.username", "A user with this username already exists");

        }

        return "redirect:/landing";

    }
}
