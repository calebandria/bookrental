package com.kaleba.bookrental.bookrental.service.impl;

import java.util.Collections;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.RegistrationDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.model.Role;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;
import com.kaleba.bookrental.bookrental.repository.RoleRepository;
import com.kaleba.bookrental.bookrental.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private AdherentRepository adherentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;

    public RegistrationServiceImpl(AdherentRepository adherentRepository){
        this.adherentRepository = adherentRepository;
    }

    @Override
    public boolean registerUser(RegistrationDto form) {
        if(adherentRepository.findByUsername(form.getUsername()).isPresent()) {
            return false;
        }

        Adherent adherent = maptoAdherent(form);
        adherentRepository.save(adherent);

        return true;
    }

    private Adherent maptoAdherent(RegistrationDto form){
        Adherent newAdherent = new Adherent();

        newAdherent.setIdAdherent(form.getIdAdherent());
        newAdherent.setNom(form.getNom());
        newAdherent.setPrenom(form.getPrenom());
        newAdherent.setUsername(form.getUsername());
        newAdherent.setPassword(passwordEncoder.encode(form.getPassword()));
    
        Role defaultRole = roleRepository.findByName("USER")
        .orElseThrow(() -> new RuntimeException("Default role not found"));
        newAdherent.setRoles(Collections.singletonList(defaultRole));
        
        return newAdherent;
    }

}

    