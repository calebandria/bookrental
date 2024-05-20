package com.kaleba.bookrental.bookrental.service;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.PretDto;
import com.kaleba.bookrental.bookrental.model.Pret;

@Service
public interface PretService {
    Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire);
}
