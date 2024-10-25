package com.kaleba.bookrental.bookrental.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    @GetMapping("/landing")
    public String Home(){
        return "landingpage";
    }
}