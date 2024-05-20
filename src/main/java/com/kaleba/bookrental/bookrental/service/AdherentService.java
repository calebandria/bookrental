package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.AdherentDto;
import com.kaleba.bookrental.bookrental.model.Adherent;



@Service
public interface AdherentService {
    List<Adherent> findAllAdherents();

    List<AdherentDto> findAllAdherentDtos();
      
    

    Adherent saveAdherent(AdherentDto adherentDto);

    AdherentDto findAdherentById(int idAdherent);

    void updateAdherent(AdherentDto adherent);

    void delete(int idLivre);
}
