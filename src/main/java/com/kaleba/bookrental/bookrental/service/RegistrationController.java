package com.kaleba.bookrental.bookrental.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.RegistrationDto;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;

@Service
public class RegistrationController{
    
    @Autowired
    private AdherentRepository adherentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean registerUser(RegistrationDto form) {
        if(adherentRepository.findByUsername(form.getUsername()).isPresent()){
            return false;
        }

        // creation of new user
        Adherent newAdherent = new Adherent();
    }
}