package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.PretDto;
import com.kaleba.bookrental.bookrental.model.Pret;

@Service
public interface PretService {
    Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire);
/*     List<PretDto> findAllPretsDto(); */
    List<Pret> findAllPrets();
    List<PretDto>findAllPretsDto();
}
