package com.kaleba.bookrental.bookrental.service.impl;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.PretDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.model.Pret;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;
import com.kaleba.bookrental.bookrental.repository.ExemplaireRepository;
import com.kaleba.bookrental.bookrental.repository.PretRepository;
import com.kaleba.bookrental.bookrental.service.PretService;

@Service
public class PretServiceImpl implements PretService{
    private PretRepository pretRepository;
    private AdherentRepository adherentRepository;
    private ExemplaireRepository exemplaireRepository;


    public PretServiceImpl(PretRepository pretRepository){
        this.pretRepository = pretRepository;
    }
    
    @Override
    public Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire) {
        Pret pret = mapToPret(pretDto);
        Adherent adherent = adherentRepository.findById(idAdherent).get();
        Exemplaire exemplaire = exemplaireRepository.findById(idExemplaire).get();
        pret.setAdherent(adherent);
        pret.setExemplaire(exemplaire);
        pretRepository.save(pret);

        return pret;
    }

    private Pret mapToPret(PretDto pretDto) {
        Pret pret = new Pret();

        pret.setIdPret(pretDto.getIdPret());
        pret.setDatePret(pretDto.getDatePret());
        pret.setDateRemise(pretDto.getDateRemise());

        return pret;
    }
}   
