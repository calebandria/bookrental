package com.kaleba.bookrental.bookrental.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.kaleba.bookrental.bookrental.dto.AdherentDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;
import com.kaleba.bookrental.bookrental.service.AdherentService;



@Service
public class AdherentServiceImpl implements AdherentService {
    private AdherentRepository adherentRepository;

    public AdherentServiceImpl(AdherentRepository adherentRepository){
        this.adherentRepository = adherentRepository;

    }
    @Override
    public List<Adherent> findAllAdherents(){
        return adherentRepository.findAll();

    }

    @Override
    public List<AdherentDto> findAllAdherentDtos(){
        List<Adherent> adherents = adherentRepository.findAll();
        
        return adherents.stream().map(adherent -> mapToAdherentDto(adherent)).collect(Collectors.toList());

    }
    
    private AdherentDto mapToAdherentDto(Adherent adherent) {
        AdherentDto adherentDto = new AdherentDto();

        adherentDto.setIdAdherent(adherent.getIdAdherent());
        adherentDto.setNom(adherent.getNom());
        adherentDto.setPrenom(adherent.getPrenom());
        adherentDto.setDateAdhesion(adherent.getDateAdhesion());


        return adherentDto;
    }
    
    @Override
    public Adherent saveAdherent(AdherentDto adherentDto){
        Adherent adherent = maptoAdherent(adherentDto);
        return adherentRepository.save(adherent);
    }

    private Adherent maptoAdherent(AdherentDto adherentDto){
        Adherent adherent = new Adherent();

        adherent.setIdAdherent(adherentDto.getIdAdherent());
        adherent.setNom(adherentDto.getNom());
        adherent.setPrenom(adherentDto.getPrenom());
        adherent.setDateAdhesion(adherentDto.getDateAdhesion());

        return adherent;

    }
    @Override
    public AdherentDto findAdherentById(int idAdherent) {
        Adherent adherent = adherentRepository.findById(idAdherent).get();
        return mapToAdherentDto(adherent);
    }
    @Override
    public void updateAdherent(AdherentDto adherentDto) {
        Adherent adherent = maptoAdherent(adherentDto);
        adherentRepository.save(adherent);
    }
    @Override
    public void delete(int idAdherent) {
       adherentRepository.deleteById(idAdherent);
    }
}
